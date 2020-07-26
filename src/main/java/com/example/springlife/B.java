package com.example.springlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

    A a;

    public A getA() {
        return a;
    }
    @Autowired
    public void setA(A a) {
        System.err.println("b set a");
        this.a = a;
    }

    public B() {
        System.err.println("B init");
    }
}
