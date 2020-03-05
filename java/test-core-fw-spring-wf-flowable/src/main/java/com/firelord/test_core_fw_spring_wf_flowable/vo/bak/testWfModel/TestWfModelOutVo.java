package com.firelord.test_core_fw_spring_wf_flowable.vo.bak.testWfModel;

import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFModelVo4Chg;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class TestWfModelOutVo {
    //#region Fields

    @Setter
    @Getter
    private List<WFModelVo4Chg> wfModelVo4Chgs = new ArrayList<>();

    @Setter
    @Getter
    private List<TestWfModelOutItemVo> testWfModelOutItemVos = new ArrayList<>();

    //#endregion
}
