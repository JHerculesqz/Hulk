package com.firelord;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.firelord.component.db.mybatis.mapper")
public class CoreFwSpringTestDbMyBatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreFwSpringTestDbMyBatisApplication.class, args);
    }
}
