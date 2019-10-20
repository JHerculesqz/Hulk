package com.firelord.j2se;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J2SEService {
    //#region testArrays

    public static void testArrays() {
        String[] arr = new String[3];
        arr[0] = "a";
        arr[1] = "b";
        arr[2] = "c";
        List<String> lst = Arrays.asList(arr);
//        lst.add("d");

        List<String> lst2 = new java.util.ArrayList<>(Arrays.asList(arr));
//        lst.add("d");

        List<String> lst3 = new ArrayList<>();
        lst3.add("a");
        lst3.add("b");
        lst3.add("c");
        Object[] arr3 = lst3.toArray();
        String[] arr41 = new String[2];
        String[] arr42 = lst3.toArray(arr41);
        String[] arr51 = new String[3];
        String[] arr52 = lst3.toArray(arr51);
        String[] arr61 = new String[4];
        String[] arr62 = lst3.toArray(arr61);

        int count = 100 * 100 * 100;
        List<Double> lst4 = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            lst4.add(i * 1.0);
        }
        long start = System.nanoTime();
        Double[] minArr = new Double[count - 1];
        lst4.toArray(minArr);
        long mid1 = System.nanoTime();
        Double[] equalArr = new Double[count];
        lst4.toArray(equalArr);
        long mid2 = System.nanoTime();
        Double[] maxArr = new Double[count * 2];
        lst4.toArray(maxArr);
        long end = System.nanoTime();
        System.out.println("minArr:" + (mid1 - start) / (1000.0 * 1000.0) + "ms");
        System.out.println("equalArr:" + (mid2 - mid1) / (1000.0 * 1000.0) + "ms");
        System.out.println("maxArr:" + (end - mid2) / (1000.0 * 1000.0) + "ms");
    }

    //#endregion

    //#region testExtendsSuper

    public static void testExtendsSuper(){
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Garfield> garfields = new ArrayList<>();
        animals.add(new Animal());
        cats.add(new Cat());
        garfields.add(new Garfield());

//        List<? extends Cat> extendsFromAnimal = animals; //放Cat和Cat的子类
        List<? super Cat> superFromAnimal = animals;

        List<? extends Cat> extendsFromCat = cats;
        List<? super Cat> superFromCat = cats;

        List<? extends Cat> extendsFromGarfield = garfields;
//        List<? super Cat> superFromGarfield = garfields; //放Cat和Cat的父类

        //extends集合不可add
//        extendsFromCat.add(new Animal());
//        extendsFromCat.add(new Cat());
//        extendsFromCat.add(new Garfield());

//        superFromCat.add(new Animal()); //只能加Cat和Cat的子类
        superFromCat.add(new Cat());
        superFromCat.add(new Garfield());

        //super集合的get返回的只能是Object
        //这样写会报错
//        Animal animalInSuper = superFromAnimal.get(0);
        Object animalInSuper = superFromAnimal.get(0);
        Object catInSuper = superFromCat.get(0);

        Cat catInExtends = extendsFromCat.get(0);
//        Garfield garfieldInExtends = extendsFromGarfield.get(0); //泛型丢失，无法转型
    }

    //#endregion

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

    static class InnerClass1 {
    }

    class InnerClass2 {
    }

    public static void innerClassContainer() {
        class InnerClass3 {
        }
        InnerClass3 o = new InnerClass3();
    }

    interface InnerClass4 {
    }

    public static void innerClassContainer2(InnerClass4 oCallback) {
    }

    public static void testInnerClass() {
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
