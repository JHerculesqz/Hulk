package com.firelord.component.ds.id;

import org.apache.commons.io.Charsets;

import java.util.UUID;

/**
 * IDUtilsEx
 */
public class IDUtilsEx {
    //#region gen

    /**
     * gen guid
     *
     * @return guid string
     */
    public static String gen() {
        return UUID.randomUUID().toString();
    }

    /**
     * gen guiid by key
     *
     * @param strKey key
     * @return guid string
     */
    public static String gen(String strKey) {
        String strId = UUID.nameUUIDFromBytes(strKey.getBytes(Charsets.UTF_8)).toString();
        return strId;
    }

    //#endregion
}
