package com.firelord.test_core_fw_spring_wf_flowable.vo.bak.testWfModel;

import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFModelStepVo4Chg;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class TestWfModelOutItemVo {
    //#region Fields

    @Setter
    @Getter
    private String modelKey;

    @Setter
    @Getter
    private List<WFModelStepVo4Chg> wfModelStepVo4Chgs = new ArrayList<>();

    //#endregion
}
