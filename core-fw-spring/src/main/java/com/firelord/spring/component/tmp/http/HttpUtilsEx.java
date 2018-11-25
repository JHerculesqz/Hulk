package com.firelord.spring.component.tmp.http;

import com.firelord.spring.component.tmp.http.provider.rest_template.RestTemplateProvider;
import com.firelord.spring.core.ioc.IOCUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpUtilsEx {
	// #region getRestTemplateProvider

	public static RestTemplateProvider getProvider() {
		RestTemplateProvider oRestTemplateProvider = IOCUtils.getInstance().getBean(RestTemplateProvider.class);
		return oRestTemplateProvider;
	}

	// #endregion

	// #region download

	public static void download(String strFilePath, HttpServletResponse oResponse) {
		File oFile = new File(strFilePath);
		if (oFile.exists()) {
			try {
				oResponse.setContentType("application/force-download");
				oResponse.setHeader("Content-Disposition", "attachment;fileName=" + oFile.getName());
				// get your file as InputStream
				InputStream is = new FileInputStream(oFile);
				// copy it to response's OutputStream
				org.apache.commons.io.IOUtils.copy(is, oResponse.getOutputStream());
				oResponse.flushBuffer();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	// #endregion
}
