package com.firelord;

import com.firelord.j2se.ClassA;
import com.firelord.j2se.ClassB;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
//        J2SEService.testBigEndian();
//        J2SEService.testFormalAndActualParameter();
//        new J2SEService().testGetClassName();
        ClassB oB = new ClassA();
        System.out.println(oB.num);
//        J2SEService.testBreak();
//        J2SEService.testEncode();
//        J2SEService.testFloat();
//        WCSRService.testProxy();
//        WCSRService.testDecorator();
//        WCSRService.testAdapter();
//        WCSRService.testSingleton();
//        WCSRService.testObserver();
    }
}
