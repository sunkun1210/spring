package com.example.springlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    B a;

    public A() {
        System.err.println("A init");
    }
}
