package com.firelord.spring.component.tmp.security._2_secure._3_input._3_trojan;

import com.firelord.component.io.zip.ZipUtilsEx;
import com.firelord.component.io.zip.vo.ZipValidatorVo;
import org.owasp.esapi.ESAPI;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 潜规则：isValidFilePath/isValidDirPath可参考ESAPI.validator().isValidDirectoryPath
 * <br>
 * 潜规则：可参考ESAPI.validator().isValidFileUpload<br>
 */
public class SecureTrojanProvider {
	// #region Const

	private static final long ZIP_BOMB_SIZE = 1 * 1024 * 1024 * 1024;

	// #endregion

	// #region 4InReqVo

	// #region isValidFilePath4InReqVo

	public boolean isValidFilePath4InReqVo(String strFilePathSrc) {
		boolean bRes = strFilePathSrc.contains("..");
		return !bRes;
	}

	// #endregion

	// #region isValidDirPath4InReqVo

	public boolean isValidDirPath4InReqVo(String strFilePathSrc) {
		boolean bRes = strFilePathSrc.contains("..");
		return !bRes;
	}

	// #endregion

	// #region getCanonicalPath4InReqVo

	public static String getCanonicalPath4InReqVo(String strFilePathOrDirPath) {
		try {
			File oFile = new File(strFilePathOrDirPath);
			String strRes = oFile.getCanonicalPath();
			return strRes;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// #endregion

	// #endregion

	// #region 4Upload

	// #region isValid4Upload

	public boolean isValid4Upload(String strFileName, StandardMultipartHttpServletRequest oFileContentRequest) {
		// 1.validate fileName and fileType
		boolean bRes1 = ESAPI.validator().isValidFileName("[SecureTrojanProvider.isValid4Upload]", strFileName,
				ESAPI.securityConfiguration().getAllowedFileExtensions(), false);

		// 2.validate fileSize
		boolean bRes2 = false;
		try {
			Map<String, MultipartFile> mapFileContent = oFileContentRequest.getFileMap();
			for (String strFileKey : mapFileContent.keySet()) {
				MultipartFile oFileContent = mapFileContent.get(strFileKey);
				byte[] arrInput = oFileContent.getBytes();
				bRes2 = ESAPI.validator().isValidFileContent("[SecureTrojanProvider。isValid4Upload]", arrInput,
						ESAPI.securityConfiguration().getAllowedFileUploadSize(), false);
				if (!bRes2) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// return
		return bRes1 & bRes2;
	}

	// #endregion

	// #endregion

	// #region 4Zip

	public boolean isValidZip(String strFilePathZip) {
		ZipValidatorVo oZipValidatorVo = ZipUtilsEx.validate(strFilePathZip);
		boolean bIsZipBomb = oZipValidatorVo.getSize() > ZIP_BOMB_SIZE;
		boolean bIsInvalidEntryPath = oZipValidatorVo.isInvalidEntryPath();
		return !bIsZipBomb && !bIsInvalidEntryPath;
	}

	// #endregion
}
