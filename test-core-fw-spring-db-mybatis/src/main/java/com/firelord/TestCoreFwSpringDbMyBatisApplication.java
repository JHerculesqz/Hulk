package com.firelord;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.firelord.component.db.mybatis.mapper")
public class TestCoreFwSpringDbMyBatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestCoreFwSpringDbMyBatisApplication.class, args);
    }
}
