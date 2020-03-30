package com.example.spring;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactoryBean<T> implements FactoryBean<T>, InvocationHandler {

    public MyFactoryBean() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ObjectProxy execute:" + method.getName());
        return "动态代理invoke方法返回值";
    }

    @Override
    public T getObject() throws Exception {
        return   (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{},this);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
