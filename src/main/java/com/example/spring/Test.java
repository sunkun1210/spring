package com.example.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
        //把我们的这个类 注册到Spring的beanMap中去
        annotationConfigApplicationContext.register(AppConfig.class);
        //
        annotationConfigApplicationContext.refresh();
        System.out.println("========="+annotationConfigApplicationContext.getBean(Application.class).hashCode());
        System.out.println("========="+annotationConfigApplicationContext.getBean(Application.class).hashCode());
    }

}
