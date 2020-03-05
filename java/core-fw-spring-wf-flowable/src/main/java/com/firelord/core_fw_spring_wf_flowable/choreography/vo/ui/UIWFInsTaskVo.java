package com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UIWFInsTaskVo {
    //#region Fields

    @Setter
    @Getter
    private String id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String uiComponentName;

    //#endregion
}
