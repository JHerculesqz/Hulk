package com.firelord.wcsr.observ;

public class Observer2 implements IObserver {
    @Override
    public void processMsg(String strMsg) {
        System.out.println("Observer2:" + strMsg);
    }
}
