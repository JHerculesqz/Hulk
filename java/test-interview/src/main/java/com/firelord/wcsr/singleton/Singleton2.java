package com.firelord.wcsr.singleton;

/**
 * 饿汉模式(提前加载(影响启动速度)+线程安全)
 */
public class Singleton2 {
    //#region Fields

    private static Singleton2 instance = new Singleton2();

    //#endregion

    //#region Construction

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        return instance;
    }

    //#endregion
}
