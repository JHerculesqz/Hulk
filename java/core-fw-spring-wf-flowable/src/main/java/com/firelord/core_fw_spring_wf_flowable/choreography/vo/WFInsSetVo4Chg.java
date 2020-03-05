package com.firelord.core_fw_spring_wf_flowable.choreography.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class WFInsSetVo4Chg {
    //#region Fields

    @Getter
    @Setter
    private long count;

    @Getter
    @Setter
    private List<WFInsVo4Chg> lstWFInsVo4Chg = new ArrayList<>();

    //#endregion
}
