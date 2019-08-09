package com.firelord.wcsr.observ;

public class Observer1 implements IObserver {
    @Override
    public void processMsg(String strMsg) {
        System.out.println("Observer1:" + strMsg);
    }
}
