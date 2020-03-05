package com.firelord;

import com.firelord.init.InitAuto4Debug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestCoreFwSpringWfFlowableApplication implements ApplicationRunner {

    //#region Fields

    @Autowired
    private InitAuto4Debug initAuto4Debug;

    //#endregion

    //#region main

    public static void main(String[] args) {
        SpringApplication.run(TestCoreFwSpringWfFlowableApplication.class, args);
    }

    //#endregion

    //#region init

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.initAuto4Debug.run();
    }

    //#endregion
}
