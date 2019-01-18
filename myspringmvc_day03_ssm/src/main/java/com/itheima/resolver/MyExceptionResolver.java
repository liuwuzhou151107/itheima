package com.itheima.resolver;

import com.itheima.exception.AccountNotFoundException;
import com.itheima.exception.MoneyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: java类作用描述
 * @Author:
 * @CreateDate: 2019/1/16 9:52
 * @Version: 1.0
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();

        MoneyException moneyException;
        AccountNotFoundException accountNotFoundException;

        String exMsg = null;

        if(ex instanceof MoneyException){
            moneyException = (MoneyException) ex;
            exMsg = moneyException.getMessage();
        }
        if(ex instanceof AccountNotFoundException){
            accountNotFoundException = (AccountNotFoundException) ex;
            exMsg = accountNotFoundException.getMessage();
        }

        mv.addObject("exMsg",exMsg);
        mv.setViewName("error");

        return mv;
    }
}
