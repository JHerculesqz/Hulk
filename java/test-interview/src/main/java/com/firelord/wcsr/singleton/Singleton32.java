package com.firelord.wcsr.singleton;

/**
 * 懒汉模式(用时加载+线程安全(get时阻塞))
 */
public class Singleton32 {
    //#region Fields

    private static Singleton32 instance;

    //#endregion

    //#region Construction

    private Singleton32(){

    }

    public static synchronized Singleton32 getInstance(){
        if(null == instance){
            instance = new Singleton32();
        }
        return instance;
    }

    //#endregion
}
