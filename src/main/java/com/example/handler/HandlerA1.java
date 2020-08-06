package com.example.handler;

import org.springframework.stereotype.Component;

@Component
public class HandlerA1 extends  AbstractHandler{

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("1A",this);
    }

    @Override
    public void A(String name) {
        System.out.println("1111111111AAAAAAAAAAAAA");
    }

}
