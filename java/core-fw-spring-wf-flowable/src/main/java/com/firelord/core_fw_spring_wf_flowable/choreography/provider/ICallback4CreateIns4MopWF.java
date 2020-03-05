package com.firelord.core_fw_spring_wf_flowable.choreography.provider;

import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFInsVo4Chg;

public interface ICallback4CreateIns4MopWF {
    void run(WFInsVo4Chg oWFInsVo4Chg, Object oBuObj);
}
