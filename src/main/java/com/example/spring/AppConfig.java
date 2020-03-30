package com.example.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;

@Configuration
@Import(MyImportBeanDefinitionRegistrar.class)
@ComponentScan("com.example.spring")
public class AppConfig {

}
