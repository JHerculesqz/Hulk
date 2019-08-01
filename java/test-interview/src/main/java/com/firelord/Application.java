package com.firelord;

public class Application {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
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

    public static void test2() {
        for (int i = 0; i < 100; i++) {
            System.out.println(4.0 - 3.6);
        }
    }
}
