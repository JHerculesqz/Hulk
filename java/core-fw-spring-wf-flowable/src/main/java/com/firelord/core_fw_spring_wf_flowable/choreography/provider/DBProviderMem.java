package com.firelord.core_fw_spring_wf_flowable.choreography.provider;

import com.firelord.core_fw_spring_wf_flowable.choreography.vo.mop.WFLogSetVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui.UIWFInsSetVo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class DBProviderMem {
    //#region Fields

    @Setter
    @Getter
    private UIWFInsSetVo uiwfInsSetVo = new UIWFInsSetVo();

    @Setter
    @Getter
    private WFLogSetVo4Chg wfLogSetVo4Chg = new WFLogSetVo4Chg();

    //#endregion
}
