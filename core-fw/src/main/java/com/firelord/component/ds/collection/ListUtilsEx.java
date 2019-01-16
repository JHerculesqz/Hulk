package com.firelord.component.ds.collection;

import java.util.Collection;

/**
 * ListUtilsEx
 */
public class ListUtilsEx {
    //#region isEmpty

    /**
     * is collection empty
     *
     * @param lstSrc Collection<?>
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
}
