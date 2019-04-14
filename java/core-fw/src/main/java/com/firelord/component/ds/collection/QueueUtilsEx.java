package com.firelord.component.ds.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * QueueUtilsEx
 * TODO:refactor
 */
public class QueueUtilsEx {
    //#region Fields

    private BlockingQueue<Object> cache = new LinkedBlockingQueue<Object>();

    //#endregion

    //#region set

    public void set(Object oPOJO) {
        try {
            cache.put(oPOJO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //#endregion

    //#region get

    public List<Object> get() {
        List<Object> lstRes = new ArrayList<Object>();

        while (true) {
            Object oItemInQueue = cache.poll();
            if (null != oItemInQueue) {
                lstRes.add(oItemInQueue);
            }

            if (cache.isEmpty()) {
                break;
            }
        }

        return lstRes;
    }

    //#endregion
}
