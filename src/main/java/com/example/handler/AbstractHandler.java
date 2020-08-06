package com.example.handler;

import org.springframework.beans.factory.InitializingBean;

public abstract class AbstractHandler implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    /***
     * 用抽象类做模板方法
     * @param name
     */
    public void A(String name) {
        throw new UnsupportedOperationException();
    }

    public void B(String name) {
        throw new UnsupportedOperationException();
    }
}
