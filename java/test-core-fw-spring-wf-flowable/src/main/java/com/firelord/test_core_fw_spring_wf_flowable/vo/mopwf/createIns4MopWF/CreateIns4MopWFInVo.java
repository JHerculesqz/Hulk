package com.firelord.test_core_fw_spring_wf_flowable.vo.mopwf.createIns4MopWF;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class CreateIns4MopWFInVo {
    //#region Fields

    @Setter
    @Getter
    private String insId4UIWF;

    @Setter
    @Getter
    private String taskId4UIWF;

    @Setter
    @Getter
    private String modelKey;

    @Setter
    @Getter
    private Map<String, Object> mapParams = new HashMap<>();

    //#endregion
}
