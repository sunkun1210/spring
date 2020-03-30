package com.example.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AppConfig.class);
        annotationConfigApplicationContext.refresh();
        System.out.println("========="+annotationConfigApplicationContext.getBean(Application.class).getClass().getName());
    }

}
