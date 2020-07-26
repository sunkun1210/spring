package com.example.springlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    B a;

    public B getA() {
        return a;
    }

    @Autowired
    public void setA(B a) {
        System.err.println("a set b");
        this.a = a;
    }

    public A() {
        System.err.println("A init");
    }
}
