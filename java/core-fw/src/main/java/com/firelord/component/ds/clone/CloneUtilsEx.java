package com.firelord.component.ds.clone;

import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;

/**
 * CloneUtilsEx
 * TODO:refactor
 */
public class CloneUtilsEx {
    //#region deepClone

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepClone(T oObj) {
        T oRes = (T) SerializationUtils.clone(oObj);
        return oRes;
    }

    //#endregin
}
