package com.example.springlife;

import com.example.spring.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.example.springlife")
public class AppConfig {

    @Bean(initMethod="myInit",destroyMethod="myDestory")
    public Person person(){
        return new Person();
    }

}
