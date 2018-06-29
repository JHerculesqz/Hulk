package com.firelord.component.log;

//import java.io.File;
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//
//import com.firelord.component.log.provider.AnsiLogProvider;
//import com.firelord.component.log.vo.ConfigLogVo;
//import com.firelord.component.security._2_secure._3_input.SecureInputUtilsEx;
//import com.firelord.component.servlet.ServletUtilsEx;
//import com.firelord.core.ioc.IOCUtils;

public class LogUtilsEx {
	// #region log

	public static void log(String strMsg, boolean bIsDebug) {
		if (bIsDebug) {
			System.out.println(strMsg);
		}
	}

	// #endregion
}
