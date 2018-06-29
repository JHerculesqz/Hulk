package com.firelord.component.math;

import java.math.BigDecimal;

public class MathUtilsEx {
	// #region toFix

	public static double toFix(double iValue, int iFixLength) {
		double iRes = new BigDecimal(iValue).setScale(iFixLength, BigDecimal.ROUND_HALF_UP).doubleValue();
		return iRes;
	}

	// #endregion
}
