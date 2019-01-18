package com.itheima.test;

import com.itheima.controller.AccountController;
import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author:
 * @CreateDate: 2019/1/16 11:40
 * @Version: 1.0
 */
public class SsmTest {
    /**
     * 测试 dao
     */
   @Test
   public void testDao(){

       ApplicationContext AC = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
       AccountDao accountDao = (AccountDao) AC.getBean("accountDao");

       List<Account> accounts = accountDao.findAll();
       for (Account account : accounts) {
           System.out.println(account);
       }

//       Account account = accountDao.findById(1);
//       System.out.println(account);
//
//       account.setId(1);
//       account.setName("acount_update");
//       account.setMoney(10000D);
//       accountDao.update(account);
//
//        Account account1 = new Account();
//        account1.setName("account_insert");
//        account1.setMoney(888D);
//        accountDao.insert(account1);
//
//       accountDao.delete(1);
   }

   @Test
    public void testService(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");
       List<Account> accounts = accountService.findAll();
       for (Account account : accounts) {
           System.out.println(account);
       }

       accountService.transfer(2,3,500);
   }

    @Test
    public void testController(){
       ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml","springmvc/springmvc.xml");
        AccountController accountController = (AccountController) ac.getBean("accountController");
        accountController.findAll();

    }
}
