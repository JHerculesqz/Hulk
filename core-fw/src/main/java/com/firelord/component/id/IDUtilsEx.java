package com.firelord.component.id;

import java.util.UUID;

public class IDUtilsEx {
    //#region gen

    public static String gen(){
        return UUID.randomUUID().toString();
    }

    //#endregion
}
