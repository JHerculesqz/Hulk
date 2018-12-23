package com.firelord.component.os.env;

/**
 * EnvUtilsEx
 * TODO:neef refactor
 */
public class EnvUtilsEx {
    //#region Const

    /**
     * USERNAME
     */
    public static String USERNAME = "user.name";

    /**
     * USERDIR
     */
    public static String USERDIR = "user.dir";

    /**
     * USERHOME
     */
    public static String USERHOME = "user.home";

    //#endregion

    //#region getValue

    public static String getValue(String strKey) {
        String strRes = System.getProperty(strKey);
        return strRes;
    }

    //#endregion
}
