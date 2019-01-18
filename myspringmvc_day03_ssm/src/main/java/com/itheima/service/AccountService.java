package com.itheima.service;


import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 * @author ghy
 */

public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();
    /**
     * 转账
     * @param sourceId
     * @param targetId
     * @param money
     */
    void transfer(Integer sourceId,Integer targetId,double money);
}
