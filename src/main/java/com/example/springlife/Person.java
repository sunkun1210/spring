package com.example.springlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

//@Component
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    private String address;
    private int phone;
    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.err.println("【构造器】调用Person的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.err.println("【注入属性】name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.err.println("【注入属性】address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.err.println("【注入属性】phone");
        this.phone = phone;
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.err.println("【BeanFactoryAware接口】调用setBeanFactory方法");
        this.beanFactory = beanFactory;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String s) {
        System.err.println("【BeanNameAware接口】调用setBeanName方法");
        this.beanName = s;
    }

    // 这是DiposibleBean接口方法
    public void destroy() throws Exception {
        System.err.println("【DiposibleBean接口】调用destroy方法");
    }

    // 这是InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.err.println("【InitializingBean接口】调用afterPropertiesSet方法");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.err.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.err.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}