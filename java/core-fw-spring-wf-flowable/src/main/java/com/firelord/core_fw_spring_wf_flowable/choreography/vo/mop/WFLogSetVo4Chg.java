package com.firelord.core_fw_spring_wf_flowable.choreography.vo.mop;

import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFInsVo4Chg;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class WFLogSetVo4Chg {

    //#region Fields

    @Getter
    @Setter
    private long count;

    @Getter
    @Setter
    private List<WFLogVo4Chg> lstWFLogVo4Chg = new ArrayList<>();

    //#endregion
}
