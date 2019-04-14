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

    /**
     * WINROOT
     */
    public static String WINROOT = "SystemRoot";

    //#endregion

    //#region getValue

    public static String getValue(String strKey) {
        String strRes = System.getProperty(strKey);
        return strRes;
    }

    //#endregion

    //#region getEnvValue

    /**
     * getEnvValue
     *
     * @param strKey key
     * @return env value
     */
    public static String getEnvValue(String strKey) {
        String strRes = System.getenv(strKey);
        return strRes;
    }

    //#endregion
}
