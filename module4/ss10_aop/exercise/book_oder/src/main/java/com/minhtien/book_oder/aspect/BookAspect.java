package com.minhtien.book_oder.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // Để spring hiểu đc dây là lớp aspect
@Component // Tự động tạo bean
public class BookAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    .*: tất cả các phương thức
//    (..): áp dụng cho tất cả tham số

    @AfterThrowing("execution(* com.minhtien.book_oder.controller.HomeController.oder(..))")
    public void checkOder(){
        System.out.println("----------------------------------");
        System.out.println("Không còn sách để mượn");
    }
    @AfterThrowing("execution(* com.minhtien.book_oder.controller.HomeController.pay(..))")
    public void checkPay(){
        System.out.println("----------------------------------");
        System.out.println("Mã Code trả sách không hợp lệ");
    }

    @After("execution(* com.minhtien.book_oder.controller.HomeController.oder(..))")
    public void logOderDone(){
        System.out.println("----------------------------------");
        System.out.println("Mượn Sách Thành Công");
    }
    @After("execution(* com.minhtien.book_oder.controller.HomeController.pay(..))")
    public void loggerPay(){
        System.out.println("----------------------------------");
        System.out.println("Trả sách thành công");
    }
}