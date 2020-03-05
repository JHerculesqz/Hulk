package com.firelord.core_fw_spring_wf_flowable.choreography.provider;

import com.firelord.component.ds.date.DateUtilsEx;
import com.firelord.core_fw_spring_wf_flowable.choreography.WFModelUtils4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFModelStepVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui.UIWFInsSetVo;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.ui.UIWFInsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UIWFProvider {
    //#region Fields

    @Autowired
    private DBProviderMem dbProviderMem;

    @Autowired
    private WFModelUtils4Chg wfModelUtils4Chg;

    //#endregion

    //#region createIns4UIWF

    public UIWFInsVo createIns4UIWF(String strWFModelKey, String strUserId) {
        //get lstWFModelStepVo4Chg
        List<WFModelStepVo4Chg> lstWFModelStepVo4Chg = this.wfModelUtils4Chg.
                getWFModelStepLstByModelKey(strWFModelKey);

        //OutVo
        UIWFInsVo oOutVo = UIWFInsVo.createIns(lstWFModelStepVo4Chg, strUserId);

        //saveDB
        this.dbProviderMem.getUiwfInsSetVo().getLstUIWFInsVo().add(oOutVo);

        return oOutVo;
    }

    //#endregion

    //#region delIns4UIWF

    public void delIns4UIWF(String strInsId) {
        this.dbProviderMem.getUiwfInsSetVo().getLstUIWFInsVo().removeIf((oUIWFInsVo) ->
                oUIWFInsVo.getId().equals(strInsId)
        );
    }

    //#endregion

    //#region updateXXX4UIWF

    public void updateCurTaskId4UIWF(String strInsId, String strTaskId) {
        this.dbProviderMem.getUiwfInsSetVo().getLstUIWFInsVo().forEach((oUIWFInsVo) -> {
            if (oUIWFInsVo.getId().equals(strInsId)) {
                oUIWFInsVo.setCurTaskId(strTaskId);
            }
        });
    }

    public void updateFinish4UIWF(String strInsId) {
        this.dbProviderMem.getUiwfInsSetVo().getLstUIWFInsVo().forEach((oUIWFInsVo) -> {
            if (oUIWFInsVo.getId().equals(strInsId)) {
                oUIWFInsVo.setFinish(true);
                oUIWFInsVo.setEndTime(DateUtilsEx.now(DateUtilsEx.TIMEZONE_8, DateUtilsEx.FORMAT2));
            }
        });
    }

    //#endregion

    //#region get

    public UIWFInsSetVo getInsLst4UIWF(int iLimit, int iSkip) {
        UIWFInsSetVo oUIWFInsSetVo = new UIWFInsSetVo();

        List<UIWFInsVo> lstUIWFInsVo = this.dbProviderMem.getUiwfInsSetVo().getLstUIWFInsVo().stream()
                .limit(iLimit).skip(iSkip).collect(Collectors.toList());
        oUIWFInsSetVo.setLstUIWFInsVo(lstUIWFInsVo);
        int iCount = this.dbProviderMem.getUiwfInsSetVo().getLstUIWFInsVo().size();
        oUIWFInsSetVo.setCount(iCount);

        return oUIWFInsSetVo;
    }

    public UIWFInsVo getIns4UIWF(String strInsId) {
        UIWFInsVo oOutVo = this.dbProviderMem.getUiwfInsSetVo().getLstUIWFInsVo().stream().
                filter((oUIWFInsVo) -> oUIWFInsVo.getId().equals(strInsId)).
                findAny().orElse(null);
        return oOutVo;
    }

    //#endregion
}
