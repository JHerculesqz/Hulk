package com.firelord.component.security._2_secure._3_input._1_validator;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.owasp.esapi.ESAPI;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.firelord.component.log.LogUtilsExIOC;
import com.firelord.component.security._2_secure._3_input._1_validator.vo.EnumInputValidator;

/**
 * SecureInputValidatorProvider oSecureInputValidatorProvider = new
 * SecureInputValidatorProvider();<br>
 * boolean bRes = oSecureInputValidatorProvider.isValidDate("2014-06-18",
 * "YYYY-MM-dd");<br>
 * bRes = oSecureInputValidatorProvider.isValidDouble("3.45", 0.01, 2.0);<br>
 * bRes = oSecureInputValidatorProvider.isValidNumber("3.45", 0, 4);<br>
 * bRes = oSecureInputValidatorProvider.isValidInteger("3.45", 0, 4);<br>
 * bRes = oSecureInputValidatorProvider .isValidFileContent(
 * "C:\\1.Monkey\\1.Research\\4.SCMGit\\demo-java-ms\\README.md", 1000000000);
 * <br>
 * bRes = oSecureInputValidatorProvider.isValidFileName("ss.zip");<br>
 * bRes = oSecureInputValidatorProvider.isValidInput("xxx@huawei.com",
 * EnumInputValidator.Email, 100);<br>
 * bRes = oSecureInputValidatorProvider.isValidListItem("si",
 * Arrays.asList("ss", "dd"));<br>
 * bRes = oSecureInputValidatorProvider.isValidPrintable("ffdsfsrgfs", 4);<br>
 * bRes = oSecureInputValidatorProvider.isValidSafeHTML(
 * "<script>alert('1')</script>", 100);<br>
 * 
 * TODO:need wrap this api<br>
 * ESAPI.validator().isValidRedirectLocation(context, input, allowNull);<br>
 */
public class SecureInputValidatorProvider {
	// #region Const

	private static final boolean IS_DEBUG = true;

	private static final String LOG_FORMAT = "[%s][INPUT]%s;[result]%s";

	// #endregion

	// #region isValidDate

	public boolean isValidDate(String strInput, String strDateFormat) {
		DateFormat oDateFormat = new SimpleDateFormat(strDateFormat);
		boolean bRes = ESAPI.validator().isValidDate("[SecureInputValidatorProvider_isValidDate]", strInput,
				oDateFormat, false);
		LogUtilsExIOC.log2File4SecureI(String.format(LOG_FORMAT, "isValidDate", strInput, bRes), IS_DEBUG);
		return bRes;
	}

	// #endregion

	// #region isValidNumber

	public boolean isValidNumber(String strInput, long minValue, long maxValue) {
		boolean bRes = ESAPI.validator().isValidNumber("[SecureInputValidatorProvider_isValidNumber]", strInput,
				minValue, maxValue, false);
		LogUtilsExIOC.log2File4SecureI(String.format(LOG_FORMAT, "isValidNumber", strInput, bRes), IS_DEBUG);
		return bRes;
	}

	// #endregion

	// #region isValidInteger

	public boolean isValidInteger(String strInput, int minValue, int maxValue) {
		boolean bRes = ESAPI.validator().isValidInteger("[SecureInputValidatorProvider_isValidInteger]", strInput,
				minValue, maxValue, false);
		LogUtilsExIOC.log2File4SecureI(String.format(LOG_FORMAT, "isValidInteger", strInput, bRes), IS_DEBUG);
		return bRes;
	}

	// #endregion

	// #region isValidDouble

	public boolean isValidDouble(String strInput, double minValue, double maxValue) {
		boolean bRes = ESAPI.validator().isValidDouble("[SecureInputValidatorProvider_isValidDouble]", strInput,
				minValue, maxValue, false);
		LogUtilsExIOC.log2File4SecureI(String.format(LOG_FORMAT, "isValidDouble", strInput, bRes), IS_DEBUG);
		return bRes;
	}

	// #endregion

	// #region isValidInput

	public boolean isValidStr(String strInput, EnumInputValidator enumInputValidator, int iMaxLength) {
		boolean bRes = ESAPI.validator().isValidInput("[SecureInputValidatorProvider_isValidInput]", strInput,
				enumInputValidator.getValue(), iMaxLength, false);
		LogUtilsExIOC.log2File4SecureI(String.format(LOG_FORMAT, "isValidInput", strInput, bRes), IS_DEBUG);
		return bRes;
	}

	// #endregion

	// #region isValidListItem

	public boolean isValidListItem(String strInput, List<String> lstValidInput) {
		boolean bRes = ESAPI.validator().isValidListItem("[SecureInputValidatorProvider_isValidListItem]", strInput,
				lstValidInput);
		LogUtilsExIOC.log2File4SecureI(String.format(LOG_FORMAT, "isValidListItem", strInput, bRes), IS_DEBUG);
		return bRes;
	}

	// #endregion

	// #region isValidPrintable

	public boolean isValidPrintable(String strInput, int iMaxLength) {
		boolean bRes = ESAPI.validator().isValidPrintable("[SecureInputValidatorProvider_isValidPrintable]", strInput,
				iMaxLength, false);
		LogUtilsExIOC.log2File4SecureI(String.format(LOG_FORMAT, "isValidPrintable", strInput, bRes), IS_DEBUG);
		return bRes;
	}

	// #endregion

	// #region isValidSafeHTML

	public boolean isValidSafeHTML(String strInput) {
		boolean bRes = ESAPI.validator().isValidSafeHTML("[SecureInputValidatorProvider_isValidPrintable]", strInput,
				2147483647, false);
		LogUtilsExIOC.log2File4SecureI(String.format(LOG_FORMAT, "isValidSafeHTML", strInput, bRes), IS_DEBUG);
		return bRes;
	}

	// #endregion

	// #region getReqVoSize

	public int getReqVoSize() {
		HttpServletRequest oRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		try {
			int iRes = oRequest.getInputStream().available();
			LogUtilsExIOC.log2File4SecureI(String.format("[getReqVoSize][ReqVoSize]%s", iRes), IS_DEBUG);
			return iRes;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// #endregion
}
