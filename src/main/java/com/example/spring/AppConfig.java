package com.example.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@MapperScan("com.example.spring")
@Import(MyImportBeanDefinitionRegistrar.class)
@ComponentScan("com.example.spring")
public class AppConfig {

}
