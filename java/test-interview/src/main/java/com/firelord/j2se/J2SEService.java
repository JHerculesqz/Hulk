package com.firelord.j2se;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;

public class J2SEService {
    //#region bigEndian

    public static void testBigEndian() throws IOException {
        byte[] arr = new byte[4];
        arr[0] = 0x78;
        arr[1] = 0x56;
        arr[2] = 0x34;
        arr[3] = 0x12;
        ByteArrayInputStream oBAIS = new ByteArrayInputStream(arr);
        DataInputStream oDIS = new DataInputStream(oBAIS);
        String strRes = Integer.toHexString(oDIS.readInt());
        System.out.println("JVM:" + strRes);
        System.out.println("CPU:" + ByteOrder.nativeOrder());
    }

    //#endregion

    //#region formalAndActualParameter

    public static void testFormalAndActualParameter() {
        StringBuilder oSB1 = new StringBuilder("Hello");
        StringBuilder oSB2 = new StringBuilder("Hello");
        int i = 1;
        testFormalAndActualParameter(oSB1, oSB2, i);
        System.out.println(oSB1.toString());
        System.out.println(oSB2.toString());
        System.out.println(i);
    }

    private static void testFormalAndActualParameter(StringBuilder oArg1,
                                                     StringBuilder oArg2,
                                                     int iArg3) {
        oArg1.append(" World");
        oArg2 = new StringBuilder("Test");
        iArg3 = 2;
    }

    //#endregion

    //#region getClassName

    public void testGetClassName() {
        System.out.println("getClassName:" + super.getClass().getName());
        System.out.println("getSuperClassName:" + this.getClass().getSuperclass().getName());
    }

    //#endregion

    //#region localVar

    public static void testLocalVar() {
//        int i, j, k;
//        i = 100;
//        while (i > 0) {
//            i = j * 2;
//            System.out.println(j);
//            k = k + 1;
//            i--;
//        }
    }

    //#endregion

    //#region innerClass

    static class InnerClass1{}
    class InnerClass2{}
    public static void innerClassContainer(){
        class InnerClass3{}
        InnerClass3 o = new InnerClass3();
    }
    interface InnerClass4{}
    public static void innerClassContainer2(InnerClass4 oCallback){}
    public static void testInnerClass(){
        new J2SEService.InnerClass1();
        new J2SEService();
        innerClassContainer();
        innerClassContainer2(new InnerClass4() {
        });
    }

    //#endregion

    //#region

    public static void test() {
        Integer.parseInt("12");
        Integer.valueOf("12").intValue();

        //byte a = 340;
        //Byte b = 120;
    }

    //#endregion

    //#region testBreak

    public static void testBreak() {
        Byte a = 120;

        A:

        for (int i = 0; i < 100; i++) {
            System.out.println("i:" + i);

            for (int j = 0; j < 100; j++) {
                System.out.println("j:" + j);
                if (j == 10) {
                    break A;
                }
            }
        }

        System.out.println("88");
    }

    //#endregion

    //#region testEncode

    public static void testEncode() {
        try {
            String str1 = "涓\uE15F枃";
            String str2 = new String(str1.getBytes("GBK"), "UTF-8");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //#endregion

    //#region testFloat

    public static void testFloat() {
        String s = "123456";
        String s1 = "123456";
        String s2 = "123" + "456";
        String s3 = "456";
        String s4 = "123" + s3;
        System.out.print(s == s1);
        System.out.print(s == s2);
        System.out.print(s == s4);
        String str11 = Integer.toString(3);
        System.out.print(new Integer(42) == new Integer(42));
        for (int i = 0; i < 100; i++) {
            System.out.println(4.0 - 3.6);
        }
    }

    //#endregion
}
