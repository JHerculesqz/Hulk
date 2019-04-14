package com.firelord.component.ds.random;


import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static <T> List<T> nextList(int iCount, List<T> lstTarget) {
        List<T> lstRes = new ArrayList<>();

        //if lstTarget size less than iCount
        if (lstTarget.size() <= iCount) {
            for (T oT : lstTarget) {
                lstRes.add(oT);
            }
        }
        //if lstTarget size greater than iCount
        else {
            Map<Integer, String> mapRandomIndex = new HashMap<>();

            while (mapRandomIndex.size() < iCount) {
                int iRandomIndex = (int) (Math.random() * lstTarget.size());
                if (!mapRandomIndex.containsKey(iRandomIndex)) {
                    mapRandomIndex.put(iRandomIndex, "");
                    lstRes.add(lstTarget.get(iRandomIndex));
                }
            }

            mapRandomIndex.clear();
        }

        return lstRes;
    }

    //#endregion
}
