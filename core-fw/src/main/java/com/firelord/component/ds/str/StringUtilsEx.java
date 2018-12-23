package com.firelord.component.ds.str;

import org.apache.commons.lang.StringUtils;

import java.text.DecimalFormat;

/**
 * StringUtilsEx
 */
public class StringUtilsEx {
    //#region Const

    private static String hexStr = "0123456789ABCDEF";
    private static String[] binaryArray = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000",
            "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    //#endregion

    //#region split

    public static String[] splitWithoutSpace(String strSrc) {
        return StringUtils.split(strSrc, null);
    }

    public static String[] splitWithoutSpace(String strSrc, String strSplit) {
        return StringUtils.split(strSrc, strSplit);
    }

    //#endregion

    //#region isNullOrEmpty

    public static boolean isNullOrEmpty(String strSrc) {
        return StringUtils.isEmpty(strSrc);
    }

    //#endregion

    //#region hex

    /**
     * @param bArray bArray
     * @return 二进制数组转换为二进制字符串 2-2
     */
    public static String bytes2BinStr(byte[] bArray) {
        String outStr = "";
        int pos = 0;
        for (byte b : bArray) {
            //高四位
            pos = (b & 0xF0) >> 4;
            outStr += binaryArray[pos];
            //低四位
            pos = b & 0x0F;
            outStr += binaryArray[pos];
        }
        return outStr;
    }

    /**
     * @param bytes bytes
     * @return 将二进制数组转换为十六进制字符串 2-16
     */
    public static String bin2HexStr(byte[] bytes) {
        String result = "";
        String hex = "";
        for (int i = 0; i < bytes.length; i++) {
            //字节高4位
            hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
            //字节低4位
            hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
            result += hex; //+" "
        }
        return result;
    }

    /**
     * @param hexString hexString
     * @return 将十六进制转换为二进制字节数组 16-2
     */
    public static byte[] hexStr2BinArr(String hexString) {
        //hexString的长度对2取整，作为bytes的长度
        int len = hexString.length() / 2;
        byte[] bytes = new byte[len];
        byte high = 0;//字节高四位
        byte low = 0;//字节低四位
        for (int i = 0; i < len; i++) {
            //右移四位得到高位
            high = (byte) ((hexStr.indexOf(hexString.charAt(2 * i))) << 4);
            low = (byte) hexStr.indexOf(hexString.charAt(2 * i + 1));
            bytes[i] = (byte) (high | low);//高地位做或运算
        }
        return bytes;
    }

    /**
     * new:16 to 10
     *
     * @param strSrc strSrc
     * @return int
     */
    public static int hexStr2Dec(String strSrc) {
        return Integer.parseInt(strSrc, 16);
    }

    /**
     * new:16 to 2
     *
     * @param hexString hexString
     * @return String
     */
    public static String hexStr2bitStr(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }

    /**
     * new:16 to Long
     *
     * @param hexString hexString
     * @return String
     */
    public static String hexStr2LongStr(String hexString) {
        return String.valueOf(Long.parseLong(hexString, 16));
    }

    /**
     * new:16 to Float
     *
     * @param hexString hexString
     * @return String
     */
    public static String hexStr2FloatStr(String hexString) {
        Long iTmp = Long.parseLong(hexString, 16);
        float fTmp = Float.intBitsToFloat(iTmp.intValue());
        DecimalFormat oFormat = new DecimalFormat("##0.00");
        return oFormat.format(fTmp);
    }

    /**
     * TODO:16进制 to 有符号10
     *
     * @return String
     */
    public static String hexStr2SignDecStr() {
        return null;
    }

    //#endregion
}
