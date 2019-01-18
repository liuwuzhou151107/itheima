package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @Description: java类作用描述
 * @Author:
 * @CreateDate: 2019/1/16 10:56
 * @Version: 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        mv.addObject("accounts",accounts);
        mv.setViewName("account-list");
        return mv;
    }
    @RequestMapping("/transfer")
    public ModelAndView transfer(Integer sourceId,Integer targetId,double money){
        ModelAndView mv = new ModelAndView();
        accountService.transfer(sourceId,targetId,money);
        mv.addObject("msg","转账成功");
        mv.setViewName("success");
        return mv;
    }
}
