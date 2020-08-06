package com.example.handler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        String name="1A";
        AbstractHandler handler = Factory.getInvokeStrategy(name);
        handler.A(name);
        String name2="2B";
        AbstractHandler handler2 = Factory.getInvokeStrategy(name2);
        handler2.B(name2);

    }


}
