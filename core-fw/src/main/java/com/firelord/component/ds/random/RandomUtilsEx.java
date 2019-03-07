package com.firelord.component.ds.random;


import org.apache.commons.lang3.RandomUtils;

public class RandomUtilsEx {
    //#region next

    public static int nextIntEx(int iMin, int iMax) {
        return RandomUtils.nextInt(iMin, iMax);
    }

    public static double nextInt(int iMin, int iMax) {
        return RandomUtils.nextInt(iMin, iMax);
    }

    public static double nextDouble(double iMin, double iMax) {
        return RandomUtils.nextDouble(iMin, iMax);
    }

    //#endregion
}
