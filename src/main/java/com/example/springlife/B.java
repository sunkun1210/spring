package com.example.springlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
    @Autowired
    A a;

    public B() {
        System.err.println("B init");
    }
}
