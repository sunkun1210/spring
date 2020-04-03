package com.example.proxy;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/***
 * c、通过FactoryBean实现接口代理
 * @param <T>
 */
public class ProxyFactoryBean<T> implements FactoryBean<T> , InvocationHandler {

    public ProxyFactoryBean(){
        System.err.println("ProxyFactoryBean构造方法开始");
    }
    private Class serviceInterface;
    @Override
    public T getObject() throws Exception {
        System.err.println("返回动态代理对象开始");
        return (T) Proxy.newProxyInstance(this.serviceInterface.getClassLoader(), new Class[]{this.serviceInterface}, this);
    }

    @Override
    public Class<?> getObjectType() {
        return BizService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("执行方法:" + method.getName());
        String param = Arrays.toString(args);
        return "动态代理invoke方法返回值="+param;
    }

    public Class getServiceInterface() {
        return serviceInterface;
    }

    public void setServiceInterface(Class serviceInterface) {
        this.serviceInterface = serviceInterface;
    }
}
