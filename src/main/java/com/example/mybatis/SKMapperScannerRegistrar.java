package com.example.mybatis;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;

public class SKMapperScannerRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        try {
            AnnotationAttributes annoAttrs =
                    AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(SKMapperScanner.class.getName()));
            String packageValue = annoAttrs.getString("value");
            String pathValue = packageValue.replace(".", "/");

            File[] files = resourceLoader.getResource(pathValue).getFile().listFiles();
            for (File file : files) {
                String name = file.getName().replace(".class", "");

                Class<?> aClass = Class.forName(packageValue + "." + name);
                if (aClass.isInterface()&&!aClass.isAnnotation()) {
                    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
                    AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
                    beanDefinition.setBeanClass(SKBeanFactoryBean.class);
                    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(packageValue + "." + name);
                    registry.registerBeanDefinition(name, beanDefinition);
                }
            }
        } catch (Exception ex) {
        }
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}