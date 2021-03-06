package com.example.springlife;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

//@Component
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.err.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
    }

    // 接口方法、实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass,String beanName) throws BeansException {
        if (beanClass.equals(Person.class)){
            System.err.println("InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
        }
        return null;
    }

    // 接口方法、实例化Bean之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)throws BeansException {
        if (bean instanceof Person){
            System.err.println("InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
        }
        return bean;
    }

    // 接口方法、设置某个属性时调用  1.0
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs,PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (bean instanceof Person){
            System.err.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
        }
        return pvs;
    }
}
