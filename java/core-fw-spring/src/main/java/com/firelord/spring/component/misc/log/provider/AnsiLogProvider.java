package com.firelord.spring.component.misc.log.provider;

@Deprecated
public class AnsiLogProvider {
    // #region Const

    public static final String ANSI_RESET = " \u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // #endregion

    // #region Fields

    private static AnsiLogProvider m_oInstance = null;

    // #endregion

    // #region Construction

    private AnsiLogProvider() {
    }

    public static synchronized AnsiLogProvider getInstance() {
        if (null == m_oInstance) {
            m_oInstance = new AnsiLogProvider();
        }
        return m_oInstance;
    }

    // #endregion

    // #region log

    public void debug(String strMsg) {
        System.out.println(strMsg);
    }

    public void info(String strMsg) {
        System.out.println(strMsg);
    }

    public void warn(String strMsg) {
        System.out.println(strMsg);
    }

    public void error(String strMsg) {
        System.out.println(strMsg);
    }

    // #endregion
}
