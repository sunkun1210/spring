package com.example.mybatis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SKMapperScanner("com.example.mybatis")
@ComponentScan
public class AppConfig {
}