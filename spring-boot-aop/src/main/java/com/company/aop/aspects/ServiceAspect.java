package com.company.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.company.aop.service.MessageService.messageSend(..))")
    public  void beforeMessageSendMethod(JoinPoint joinPoint){
        System.out.println("Parameter caught before send message method param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.company.aop.service.*.*(..))")
    public  void afterMessageSendMethod(JoinPoint joinPoint){
        System.out.println("Parameter caught after send message method param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
