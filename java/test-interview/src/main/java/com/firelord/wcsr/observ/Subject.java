package com.firelord.wcsr.observ;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    //#region Fields

    private List<IObserver> observers = new ArrayList<>();

    //#endregion

    //#region attach

    public void attach(IObserver oObserver){
        this.observers.add(oObserver);
    }

    //#endregion

    //#region detach

    public void detach(IObserver oObserver){
        this.observers.remove(oObserver);
    }

    //#endregion

    //#region publish

    public void publish(String strMsg){
        for (IObserver oObserver : observers){
            oObserver.processMsg(strMsg);
        }
    }

    //#endregion
}
