package com.minhtien.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // Để spring hiểu đc dây là lớp aspect
@Component // Tự động tạo bean
public class StudentAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    .*: tất cả các phương thức
//    (..): áp dụng cho tất cả tham số
    @After("execution(* com.minhtien.demo.controller.StudentController.*(..))")
    public void logAfterMethodCall(JoinPoint joinpoint){
        String nameMethod = joinpoint.getSignature().getName();
        logger.info("Tên Phương Thức " + nameMethod);
    }
}
