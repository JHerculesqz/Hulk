package com.firelord.spring.component.misc.log;

import com.firelord.spring.component.misc.log.provider.AnsiLogProvider;

@Deprecated
public class LogUtilsEx {
    //#region log

    public static void log(String strMsg, boolean bIsDebug) {
        if (bIsDebug) {
            System.out.println(strMsg);
        }
    }

    //#endregion

    //#region ansi

    public static void ansiInfo(String strMsg) {
        AnsiLogProvider.getInstance().info(strMsg);
    }

    public static void ansiDebug(String strMsg) {
        AnsiLogProvider.getInstance().debug(strMsg);
    }

    public static void ansiWarn(String strMsg) {
        AnsiLogProvider.getInstance().warn(strMsg);
    }

    public static void ansiError(String strMsg) {
        AnsiLogProvider.getInstance().error(strMsg);
    }

    //#endregion
}
