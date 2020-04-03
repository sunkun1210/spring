package com.example.mybatis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(SKMapperScannerRegistrar.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface SKMapperScanner {
    String value();
}