package com.example.mybatis;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SKBeanFactoryBean implements FactoryBean, InvocationHandler {
    private Class clazz;

    public SKBeanFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SKSql annotation = method.getAnnotation(SKSql.class);
        String sql= annotation.value();
        System.out.println(sql);
        return sql;
    }

    @Override
    public Object getObject() throws Exception {
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, this);
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}