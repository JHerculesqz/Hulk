package com.firelord.j2se;

import java.io.UnsupportedEncodingException;

public class J2SEService {
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
