package com.firelord.component.misc.security;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * LazySecurityUtils
 */
public class LazySecurityUtils {
    //#region base64

    /**
     * encrypt64
     *
     * @param strSrc src string
     * @return dst string
     */
    public static String encrypt64(String strSrc) {
        String strRes = null;
        try {
            strRes = Base64.getEncoder().encodeToString(strSrc.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strRes;
    }

    /**
     * decrypt64
     *
     * @param strSrc src string
     * @return dst string
     */
    public static String decrypt64(String strSrc) {
        String strRes = null;
        try {
            byte[] arrBytes = Base64.getDecoder().decode(strSrc);
            strRes = new String(arrBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strRes;
    }

    //#endregion
}
