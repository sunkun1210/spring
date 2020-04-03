package com.example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    UserRepo userRepo;

    public  void get(){
        userRepo.get();
    }
}
