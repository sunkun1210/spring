package com.example.proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Deprecated
@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        System.err.println("############修改bean定义的属性############");
//        ProxyFactoryBean beanDefinition= beanFactory.getBean(ProxyFactoryBean.class);
//        beanDefinition.setServiceInterface(BizService.class);
    }
}
