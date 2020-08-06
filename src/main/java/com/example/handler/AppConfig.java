package com.example.handler;

import com.example.mybatis.SKMapperScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SKMapperScanner("com.example.handler")
@ComponentScan
public class AppConfig {
}
