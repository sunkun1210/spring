package com.example.handler;

import org.springframework.stereotype.Component;

@Component
public class HandlerB1 extends  AbstractHandler{
    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("2B",this);
    }

    @Override
    public void B(String name) {
        System.out.println("222222222BBBBBBBBBBBBBB");
    }


}
