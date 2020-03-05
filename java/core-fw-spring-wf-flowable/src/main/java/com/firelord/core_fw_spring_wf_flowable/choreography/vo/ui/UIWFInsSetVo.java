package com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class UIWFInsSetVo {
    //#region Fields

    @Getter
    @Setter
    private long count;

    @Getter
    @Setter
    private List<UIWFInsVo> lstUIWFInsVo = new ArrayList<>();

    //#endregion
}
