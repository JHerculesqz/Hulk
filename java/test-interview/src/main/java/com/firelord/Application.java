package com.firelord;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Application {


    public static void main(String[] args) throws IOException {
        Comparator<Integer> o = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1);
            }
        };
        System.out.println(o.compare(new Integer(1), new Integer(1)));

        List<String> a1 = new LinkedList<>();
        List<Integer> a2 = new LinkedList<>();
        System.out.println(a1.getClass().equals(a2.getClass()));
        System.out.println(a1.getClass() == a2.getClass());

//        J2SEService.testStr();
//        J2SEService.testArrays();
//        J2SEService.testExtendsSuper();
//        J2SEService.testBigEndian();
//        J2SEService.testFormalAndActualParameter();
//        new J2SEService().testGetClassName();
//        ClassB oB = new ClassA();
//        System.out.println(oB.num);
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
