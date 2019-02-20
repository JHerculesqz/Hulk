package com.firelord.component.ds.math;

import java.math.BigDecimal;

/**
 * MathUtilsEx
 */
public class MathUtilsEx {
    //#region toFix

    /**
     * toFix
     *
     * @param iValue     value
     * @param iFixLength fix length
     * @return double
     */
    public static double toFix(double iValue, int iFixLength) {
        double iRes = new BigDecimal(iValue).setScale(iFixLength, BigDecimal.ROUND_HALF_UP).doubleValue();
        return iRes;
    }

    //#endregion
}
