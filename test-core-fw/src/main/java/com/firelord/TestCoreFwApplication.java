package com.firelord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestCoreFwApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestCoreFwApplication.class, args);
    }
}
