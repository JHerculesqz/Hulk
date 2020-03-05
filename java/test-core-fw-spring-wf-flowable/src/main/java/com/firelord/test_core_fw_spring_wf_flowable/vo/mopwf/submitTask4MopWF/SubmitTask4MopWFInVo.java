package com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.submitTask4MopWF;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class SubmitTask4MopWFInVo {
    //#region Fields

    @Setter
    @Getter
    private String insId;

    @Setter
    @Getter
    private Map<String, Object> mapParams = new HashMap<>();

    //#endregion
}
