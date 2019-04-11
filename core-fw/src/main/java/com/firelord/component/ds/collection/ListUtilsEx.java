package com.firelord.component.ds.collection;

import java.util.Collection;
import java.util.List;

/**
 * ListUtilsEx
 */
public class ListUtilsEx {
    //#region isEmpty

    /**
     * is collection empty
     *
     * @param lstSrc Collection
     * @return true:is empty
     */
    public static boolean isEmpty(Collection<?> lstSrc) {
        if (null == lstSrc) {
            return true;
        }
        if (0 == lstSrc.size()) {
            return true;
        }
        return false;
    }

    //#endregion

    //#region joinToStr

    public static String joinToStr(List<String> lstSrc) {
        String strRes = "";

        for (String strSrc : lstSrc) {
            strRes += strSrc;
        }

        return strRes;
    }

    //#endregion
}
