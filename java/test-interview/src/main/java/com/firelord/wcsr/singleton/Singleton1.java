package com.firelord.wcsr.singleton;

/**
 * Hold模式(懒加载+JVM处理线程安全)
 */
public class Singleton1 {
    //#region Construction

    private Singleton1(){

    }

    private static class SingletonHolder{
        private static Singleton1 instance = new Singleton1();
    }
    public static Singleton1 getInstance(){
        return SingletonHolder.instance;
    }

    //#endregion
}
