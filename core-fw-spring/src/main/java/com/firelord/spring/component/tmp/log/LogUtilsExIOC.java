package com.firelord.spring.component.tmp.log;

import com.firelord.spring.component.mvc.servlet.ServletUtilsEx;
import com.firelord.spring.component.tmp.log.vo.ConfigLogVo;
import com.firelord.spring.component.tmp.security._2_secure._3_input.SecureInputUtilsEx;
import com.firelord.spring.core.ioc.IOCUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class LogUtilsExIOC {
    //#region log2File

    public static void log2File(String strMsg, Class<?> oClazz, boolean bIsDebug) {
        if (bIsDebug) {
            ConfigLogVo oConfigLogVo = IOCUtils.getInstance().getBean(ConfigLogVo.class);
            File oFile = new File(oConfigLogVo.getDirPathRoot() + File.separator + oClazz.getSimpleName() + ".txt");
            try {
                FileUtils.writeStringToFile(oFile, strMsg + "\r\n", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //#endregion

    //#region log2File4Secure

    public static void log2File4SecureI(String strMsg, boolean bIsDebug) {
        writeLog4Secure(strMsg, bIsDebug, "inputValidator.txt");
    }

    public static void log2File4SecureO(String strMsg, boolean bIsDebug) {
        writeLog4Secure(strMsg, bIsDebug, "outputValidator.txt");
    }

    public static void log2File4SecureE(String strMsg, boolean bIsDebug) {
        writeLog4Secure(strMsg, bIsDebug, "encrypt.txt");
    }

    private static void writeLog4Secure(String strMsg, boolean bIsDebug, String strFileName4Log) {
        if (bIsDebug) {
            // 1.get strRemoteIp strUrl
            ConfigLogVo oConfigLogVo = IOCUtils.getInstance().getBean(ConfigLogVo.class);
            String strRemoteIp = SecureInputUtilsEx.getInstance().getHeaderProvider().getHeader4RemoteIp();
            String strUrl = ServletUtilsEx.getRequestUrl().replace("/", "_");

            // 2.write log
            String strFilePath4Log = oConfigLogVo.getDirPathRoot() + File.separator + strRemoteIp + File.separator
                    + strUrl + File.separator + strFileName4Log;
            File oFile = new File(strFilePath4Log);
            try {
                FileUtils.writeStringToFile(oFile, strMsg + "\r\n", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //#endregion
}
