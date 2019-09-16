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
