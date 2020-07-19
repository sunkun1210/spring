package com.example.springlife;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        Person person=annotationConfigApplicationContext.getBean(Person.class);
        System.out.println(person);
        System.out.println("现在开始关闭容器！");
        annotationConfigApplicationContext.registerShutdownHook();
    }
}
