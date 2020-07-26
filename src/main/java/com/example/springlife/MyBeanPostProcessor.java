package com.example.springlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//@Component
public class MyBeanPostProcessor implements BeanPostProcessor{
    public MyBeanPostProcessor() {
        System.out.println("这是BeanPostProcessor实现类构造器！！");
    }
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        if (bean instanceof Person) {
            System.err.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        if (bean instanceof Person) {
            System.err.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改");
        }
        return bean;
    }
}