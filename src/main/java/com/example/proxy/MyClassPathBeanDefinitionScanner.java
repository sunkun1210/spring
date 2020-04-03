package com.example.proxy;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/***
 *    b、扫描指定的路径，接口定义
 */
@Deprecated
public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }
    @Override
    protected void registerDefaultFilters() {
        //扫描规则
//        this.addIncludeFilter(new AnnotationTypeFilter(Refrence.class));
        this.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
    }
    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        System.out.println("doScan扫描开始&&&&&&&&&&&&&&&"+basePackages+"&&&&&&&&&&&&&");
        //返回扫描包下面的所有接口!!!  优点可以for循环
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        for (BeanDefinitionHolder holder : beanDefinitions) {
            GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
            definition.setBeanClass(ProxyFactoryBean.class);
            this.getRegistry().registerBeanDefinition(holder.getBeanName(), definition);
        }
        return beanDefinitions;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
    }

}
