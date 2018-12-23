package com.firelord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestCoreFwSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestCoreFwSpringApplication.class, args);
    }
}
