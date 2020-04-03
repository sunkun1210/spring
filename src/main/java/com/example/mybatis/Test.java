package com.example.mybatis;


import com.example.spring.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;


public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        UserRepo myService =annotationConfigApplicationContext.getBean(UserRepo.class);
        myService.get();
    }


//    @Autowired
//    UserRepo userRepo;
//
//    public  void get(){
//        userRepo.get();
//    }
}