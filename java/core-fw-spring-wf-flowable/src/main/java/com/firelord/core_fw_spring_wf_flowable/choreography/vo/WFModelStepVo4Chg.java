package com.firelord.core_fw_spring_wf_flowable.choreography.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class WFModelStepVo4Chg {
    //#region Fields

    @Setter
    @Getter
    private String id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String uiCompName;

    @Setter
    @Getter
    private List<WFModelStepVo4Chg> lstWFModelStepVo4Chg = new ArrayList<>();

    //#endregion
}
