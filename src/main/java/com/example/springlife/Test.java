package com.example.springlife;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        A a=annotationConfigApplicationContext.getBean(A.class);

       // annotationConfigApplicationContext.registerShutdownHook();
    }
}
