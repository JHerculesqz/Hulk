package com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui;

import com.firelord.component.ds.date.DateUtilsEx;
import com.firelord.component.ds.id.IDUtilsEx;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFModelStepVo4Chg;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class UIWFInsVo {
    //#region Fields

    @Setter
    @Getter
    private String id;

    @Setter
    @Getter
    private boolean isFinish;

    @Setter
    @Getter
    private String curTaskId;

    @Setter
    @Getter
    private List<UIWFInsTaskVo> lstUIWFInsTaskVo = new ArrayList<>();

    //#region others

    @Setter
    @Getter
    private String startTime;

    @Setter
    @Getter
    private String endTime;

    @Setter
    @Getter
    private String userId;

    //#endregion

    //#endregion

    //#region createIns

    public static UIWFInsVo createIns(List<WFModelStepVo4Chg> lstWFModelStepVo4Chg, String strUserId){
        UIWFInsVo oOutVo = new UIWFInsVo();

        //common props
        oOutVo.setId(IDUtilsEx.gen());
        oOutVo.setStartTime(DateUtilsEx.now(DateUtilsEx.TIMEZONE_8, DateUtilsEx.FORMAT2));
        oOutVo.setUserId(strUserId);

        //generate lstUIWFInsTaskVo
        for(WFModelStepVo4Chg oWFModelStepVo4Chg: lstWFModelStepVo4Chg){
            UIWFInsTaskVo oUIWFInsTaskVo = new UIWFInsTaskVo();
            oUIWFInsTaskVo.setId(IDUtilsEx.gen());
            oUIWFInsTaskVo.setName(oWFModelStepVo4Chg.getName());
            oUIWFInsTaskVo.setUiComponentName(oWFModelStepVo4Chg.getUiCompName());
            oOutVo.getLstUIWFInsTaskVo().add(oUIWFInsTaskVo);
        }

        //curTaskId
        if(oOutVo.getLstUIWFInsTaskVo().size() > 0){
            oOutVo.setCurTaskId(oOutVo.getLstUIWFInsTaskVo().get(0).getId());
        }

        return oOutVo;
    }

    //#endregion
}
