package com.firelord.core_fw_spring_wf_flowable.choreography.provider;

import com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui.UIWFInsVo;

public interface ICallback4GetWFIns4UIWF {
    void run(String strInsId, UIWFInsVo oOutVo);
}
