package com.example.proxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        BizService bizService =annotationConfigApplicationContext.getBean(BizService.class);
        bizService.getName("我是方法的参数");

    }
}
