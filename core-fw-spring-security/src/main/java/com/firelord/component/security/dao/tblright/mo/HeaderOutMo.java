package com.firelord.component.security.dao.tblright.mo;

import com.firelord.component.security.dao.tblright.TBLRight;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * HeaderOutMo
 */
@ToString
public class HeaderOutMo {
    //#region Fields

    /**
     * use identify
     */
    @Setter
    @Getter
    private String userIdentify;

    /**
     * url pattern collection
     */
    @Setter
    @Getter
    private List<String> lstUrl = new ArrayList<>();

    //#endregion

    //#region addUrlLst

    /**
     * add url pattern collection by TBLRight collection
     *
     * @param lstTBLRight TBLRight collection
     */
    public void addUrlLst(List<TBLRight> lstTBLRight) {
        for (TBLRight oTBLRight : lstTBLRight) {
            if (!this.lstUrl.contains(oTBLRight.getUrl())) {
                this.lstUrl.add(oTBLRight.getUrl());
            }
        }
    }

    //#endregion
}
