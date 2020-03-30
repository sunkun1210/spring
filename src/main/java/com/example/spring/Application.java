package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

//@SpringBootApplication
@Component
public class Application {
    public Application() {
        System.out.println("Application init -------");
    }
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}

}
