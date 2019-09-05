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
        for (int i = 0; i < 100; i++) {
            System.out.println(4.0 - 3.6);
        }
    }

    //#endregion
}
