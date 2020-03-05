package com.firelord;

import com.firelord.spring.component.mvc.startup.IInitAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestCoreFwSpringApplication implements ApplicationRunner {
    //#region Fields

    @Autowired
    private IInitAuto initAuto;

    //#endregion

    //#region main

    public static void main(String[] args) {
        SpringApplication.run(TestCoreFwSpringApplication.class, args);
    }

    //#endregion

    //#region run

    @Override
    public void run(ApplicationArguments args) {
        this.initAuto.run();
    }

    //#endregion
}
