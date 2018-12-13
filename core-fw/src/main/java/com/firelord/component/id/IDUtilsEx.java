package com.firelord.component.id;

import org.apache.commons.io.Charsets;

import java.util.UUID;

public class IDUtilsEx {
    //#region gen

    public static String gen() {
        return UUID.randomUUID().toString();
    }

    public static String gen(String strKey) {
        String strId = UUID.nameUUIDFromBytes(strKey.getBytes(Charsets.UTF_8)).toString();
        return strId;
    }

    //#endregion
}
