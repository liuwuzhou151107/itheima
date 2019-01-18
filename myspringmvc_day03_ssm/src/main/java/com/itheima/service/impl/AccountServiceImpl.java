package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.exception.MoneyException;
import com.itheima.exception.AccountNotFoundException;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description: java类作用描述
 * @Author:
 * @CreateDate: 2019/1/16 10:13
 * @Version: 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public void transfer(Integer sourceId, Integer targetId, double money) {
        //查询账户
        Account sourceAccount = accountDao.findById(sourceId);
        Account targetAccount = accountDao.findById(targetId);

        //定义异常
        if(sourceAccount == null){
            throw new AccountNotFoundException("转出账户不存在。。。");
        }
        if(targetAccount == null){
            throw new AccountNotFoundException("收钱方不存在。。。");
        }
        if(money <= 0){
            throw new MoneyException("转账金额必须为整数");
        }
        //判断余额是否>转账金额
        if(sourceAccount.getMoney() < money){
            throw new MoneyException("账户余额不足");
        }
        //转账
        //1.转出
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        accountDao.update(sourceAccount);

        int i = 1/0;

        //转入
        targetAccount.setMoney(targetAccount.getMoney() +money);
        accountDao.update(targetAccount);
    }
}
