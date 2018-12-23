package com.firelord.spring.component.tmp.security._2_secure._3_input._4_ddos;

import com.firelord.spring.component.misc.log.LogUtilsEx;
import com.firelord.spring.component.mvc.servlet.ServletUtilsEx;
import com.firelord.spring.component.tmp.security._2_secure._3_input.SecureInputUtilsEx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class SecureDoSProvider {
    // #region Const

    private static final int MAX_HIT_COUNT = 100;

    private static final long MAX_TIME_PERIOD = 1000 * 10;

    private static final String DDOS_START_TIME = "DDOS_START_TIME";

    private static final String DDOS_COUNT = "DDOS_COUNT";

    private static final boolean IS_DEBUG = true;

    // #endregion

    // #region canVisit

    public boolean canVisit() {
        // 1.get oRequest
        HttpServletRequest oRequest = ServletUtilsEx.getRequest();

        // 2.get oSession
        HttpSession oSession = oRequest.getSession();

        // 3.get oDDosStartTime
        Object oDDosStartTime = oSession.getAttribute(DDOS_START_TIME);

        // 4.if first
        if (oDDosStartTime == null) {
            oSession.setAttribute(DDOS_START_TIME, new Date().getTime());
            oSession.setAttribute(DDOS_COUNT, 1);
            return true;
        }
        // 5.if not first
        else {
            // 5.0.get iDDosStartTime & iCurTime & iPeriodTime
            long iDDosStartTime = (long) oDDosStartTime;
            long iCurTime = new Date().getTime();
            long iPeriodTime = iCurTime - iDDosStartTime;

            // 5.1.if iPeriodTime >= MAX_TIME_PERIOD
            if (iPeriodTime >= MAX_TIME_PERIOD) {
                oSession.setAttribute(DDOS_START_TIME, new Date().getTime());
                oSession.setAttribute(DDOS_COUNT, 1);
                return true;
            }
            // 5.2.if iPeriodTime < MAX_TIME_PERIOD
            else {
                // 5.2.1.get iDDosCount
                int iDDosCount = (int) oSession.getAttribute(DDOS_COUNT);
                oSession.setAttribute(DDOS_COUNT, iDDosCount + 1);

                // 5.2.2.if iDDosCount >= MAX_HIT_COUNT
                if (iDDosCount >= MAX_HIT_COUNT) {
                    LogUtilsEx.log(
                            String.format("[SecureDoSProvider.canVisit]DoS attack:%s",
                                    SecureInputUtilsEx.getInstance().getHeaderProvider().getHeader4RemoteIp()),
                            IS_DEBUG);
                    return false;
                }
                // 5.2.3.if iDDosCount < MAX_HIT_COUNT
                else {
                    return true;
                }
            }
        }
    }

    // #endregion
}
