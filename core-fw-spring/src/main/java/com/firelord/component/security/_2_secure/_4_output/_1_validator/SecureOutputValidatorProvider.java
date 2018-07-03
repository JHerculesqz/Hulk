package com.firelord.component.security._2_secure._4_output._1_validator;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.Codec;
import org.owasp.esapi.codecs.MySQLCodec;
import org.owasp.esapi.codecs.WindowsCodec;
import org.owasp.esapi.errors.EncodingException;

import com.firelord.component.log.LogUtilsExIOC;

/**
 * SecureOutputValidatorProvider o = new SecureOutputValidatorProvider();<br>
 * String strRes1 =
 * o.encodeForJavaScript("window.location.href=\"www.baidu.com\"");<br>
 * String strSrc1 = ESAPI.encoder().canonicalize(strRes1);<br>
 * String strRes2 = o.encodeForCSS("alert(1)");<br>
 * String strSrc2 = ESAPI.encoder().canonicalize(strRes2);<br>
 * String strRes3 = o.encodeForDN(
 * "(\"CN=Dev-India,OU=Distribution Groups,DC=gp,DC=gl\")");<br>
 * String strSrc3 = ESAPI.encoder().canonicalize(strRes3);<br>
 * String strRes4 = o.encodeForHTML("<script>alert('1')</script>");<br>
 * String strSrc4 = ESAPI.encoder().canonicalize(strRes4);<br>
 * String strRes5 = o.encodeForHTMLAttribute(
 * "ss'><input type='button' value='hacked button>");<br>
 * String strSrc5 = ESAPI.encoder().canonicalize(strRes5);<br>
 * String strRes6 = o.encodeForLDAP("http://site.com/ldapsearch?user=*");<br>
 * String strSrc6 = ESAPI.encoder().canonicalize(strRes6);<br>
 * String strRes7 = o.encodeForOS("ping 192.168.0.1;tasklist");<br>
 * String strSrc7 = ESAPI.encoder().canonicalize(strRes7);<br>
 * String strRes8 = o.encodeForSQL("'123'or'1'='1'");<br>
 * String strSrc8 = ESAPI.encoder().canonicalize(strRes8);<br>
 * String strRes9 = o.encodeForURL("tony&role=admin");<br>
 * String strSrc9 = ESAPI.encoder().canonicalize(strRes9);<br>
 * String strRes10 =
 * o.encodeForVBScript("window.location.href=\"www.baidu.com\"");<br>
 * String strSrc10 = ESAPI.encoder().canonicalize(strRes10);<br>
 * String strRes11 = o.encodeForXML("aaa</name><role>admin</role><name>Tony");
 * <br>
 * String strSrc11 = ESAPI.encoder().canonicalize(strRes11);<br>
 * String strRes12 = o.encodeForXMLAttribute("tony' role='admin");<br>
 * String strSrc12 = ESAPI.encoder().canonicalize(strRes12);<br>
 * String strRes13 = o.encodeForXPath("'123'or'1'='1'");<br>
 * String strSrc13 = ESAPI.encoder().canonicalize(strRes13);<br>
 * 
 * @author JHercules
 *
 */
public class SecureOutputValidatorProvider {
	// #region Const

	private static final boolean IS_DEBUG = true;

	private static final String LOG_FORMAT = "[INPUT]%s;[ENCODE]%s";

	// #endregion

	// #region canonicalize

	public String canonicalize(String strInput) {
		String strRes = ESAPI.encoder().canonicalize(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForHTML

	public String encodeForHTML(String strInput) {
		String strRes = ESAPI.encoder().encodeForHTML(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForHTMLAttribute

	public String encodeForHTMLAttribute(String strInput) {
		String strRes = ESAPI.encoder().encodeForHTMLAttribute(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForURL

	public String encodeForURL(String strInput) {

		try {
			String strRes = ESAPI.encoder().encodeForURL(strInput);
			LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
			return strRes;
		} catch (EncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	// #endregion

	// #region encodeForCSS

	public String encodeForCSS(String strInput) {
		String strRes = ESAPI.encoder().encodeForCSS(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForJavaScript

	public String encodeForJavaScript(String strInput) {
		String strRes = ESAPI.encoder().encodeForJavaScript(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForVBScript

	public String encodeForVBScript(String strInput) {
		String strRes = ESAPI.encoder().encodeForVBScript(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForSQL

	public String encodeForSQL(String strInput) {
		Codec oMySQLCodec = new MySQLCodec(MySQLCodec.Mode.ANSI);
		String strRes = ESAPI.encoder().encodeForSQL(oMySQLCodec, strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForDN

	public String encodeForDN(String strInput) {
		String strRes = ESAPI.encoder().encodeForDN(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForLDAP

	public String encodeForLDAP(String strInput) {
		String strRes = ESAPI.encoder().encodeForLDAP(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForXML

	public String encodeForXML(String strInput) {
		String strRes = ESAPI.encoder().encodeForXML(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForXMLAttribute

	public String encodeForXMLAttribute(String strInput) {
		String strRes = ESAPI.encoder().encodeForXMLAttribute(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForOS

	public String encodeForOS(String strInput) {
		Codec oWindowsCodec = new WindowsCodec();
		String strRes = ESAPI.encoder().encodeForOS(oWindowsCodec, strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion

	// #region encodeForXPath

	public String encodeForXPath(String strInput) {
		String strRes = ESAPI.encoder().encodeForXPath(strInput);
		LogUtilsExIOC.log2File4SecureO(String.format(LOG_FORMAT, strInput, strRes), IS_DEBUG);
		return strRes;
	}

	// #endregion
}
