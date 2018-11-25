package com.firelord.spring.component.tmp.security._2_secure._3_input._5_whitelst;


import com.firelord.component.log.LogUtilsEx;
import com.firelord.spring.component.tmp.security._2_secure._3_input.SecureInputUtilsEx;

import java.util.Arrays;

public class SecureWhiteLstProvider {
    // #region Const

    private static final boolean IS_DEBUG = true;

    // #endregion

    // #region isValid

    public boolean canVisit(String[] arrWhiteLst) {
        // 1.get strRemoteIp
        String strRemoteIp = SecureInputUtilsEx.getInstance().getHeaderProvider().getHeader4RemoteIp();

        // 2.arrWhiteLst contains strRemoteIp
        boolean bRes = Arrays.asList(arrWhiteLst).contains(strRemoteIp);
        if (!bRes) {
            LogUtilsEx.log(String.format("[SecureWhiteLstProvider.canVisit]%s no auth visit", strRemoteIp), IS_DEBUG);
        }
        return bRes;
    }

    // #endregion
}
