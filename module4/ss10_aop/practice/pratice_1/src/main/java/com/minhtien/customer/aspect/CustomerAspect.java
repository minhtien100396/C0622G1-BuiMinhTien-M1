package com.minhtien.customer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @After("execution(* com.minhtien.customer.controller.CustomerController.*(..))")
    public void logAfterMethodCall(JoinPoint joinpoint){
        String nameMethod = joinpoint.getSignature().getName();
        logger.info("Tên Phương Thức " + nameMethod);
    }
}
