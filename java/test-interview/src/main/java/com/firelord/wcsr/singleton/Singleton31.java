package com.firelord.wcsr.singleton;

/**
 * 懒汉模式(用时加载+DCL线程安全(get时不阻塞))
 */
public class Singleton31 {
    //#region Fields

    private volatile static Singleton31 instance;

    //#endregion

    //#region Construction

    private Singleton31(){

    }

    public static Singleton31 getInstance(){
        if(null == instance){
            synchronized (Singleton31.class){
                if(null == instance){
                    instance = new Singleton31();
                }
            }
        }
        return instance;
    }

    //#endregion
}
