package com.example.proxy;

import com.example.spring.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@MapperScan("com.example.spring")
@ComponentScan("com.example.proxy")
public class AppConfig {

}
