package com.firelord.opencv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreFwOpenCVTestApplication {
    //#region Fields

    static {
        System.load("C:/1.Monkey/1.Research/1.Tools/opencv3.4.4/build/java/x86/opencv_java344.dll");
    }

    //#endregion

    public static void main(String[] args) {
        SpringApplication.run(CoreFwOpenCVTestApplication.class, args);
    }
}
