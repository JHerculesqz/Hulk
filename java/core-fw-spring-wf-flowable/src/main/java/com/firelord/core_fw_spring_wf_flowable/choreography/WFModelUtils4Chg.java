package com.firelord.core_fw_spring_wf_flowable.choreography;

import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFModelStepVo4Chg;
import com.firelord.core_fw_spring_wf_flowable.choreography.vo.WFModelVo4Chg;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.ParallelGateway;
import org.flowable.bpmn.model.UserTask;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class WFModelUtils4Chg {
    //#region Const

    public static final String TYPE_UI = "Nav";
    public static final String TYPE_MOP = "Mop";
    public static final String TYPE_ALG = "Alg";

    //#endregion

    //#region Fields

    @Autowired
    private RepositoryService repositoryService;

    //#endregion

    //#region common

    /**
     * 可选值：TYPE_xx
     *
     * @param strWFModelType strWFModelType
     * @return WFVo list
     */
    public List<WFModelVo4Chg> getWFModelLst(String strWFModelType) {
        List<WFModelVo4Chg> lstRes = new ArrayList<>();

        //find all
        List<ProcessDefinition> lstProcessDefinition = this.repositoryService.
                createProcessDefinitionQuery().list();

        //filter
        for (ProcessDefinition oProcessDefinition : lstProcessDefinition) {
            if (oProcessDefinition.getId().startsWith(strWFModelType)) {
                WFModelVo4Chg oNew = new WFModelVo4Chg();
                oNew.setId(oProcessDefinition.getId());
                oNew.setKey(oProcessDefinition.getKey());
                oNew.setName(oProcessDefinition.getName());
                oNew.setDesc(oProcessDefinition.getDescription());
                lstRes.add(oNew);
            }
        }

        return lstRes;
    }

    public List<WFModelStepVo4Chg> getWFModelStepLstByModelKey(String strWFModelKey) {
        //get oWFModelVo
        WFModelVo4Chg oWFModelVo4Chg = getWFModelByModelKey(strWFModelKey);
        if (null == oWFModelVo4Chg) {
            return new ArrayList<>();
        }

        //get lstWFModelStepVo4Chg
        List<WFModelStepVo4Chg> lstWFModelStepVo4Chg = getWFModelStep(oWFModelVo4Chg);
        return lstWFModelStepVo4Chg;
    }

    private List<WFModelStepVo4Chg> getWFModelStepLstByModelId(String strWFModelId) {
        //get oWFModelVo
        WFModelVo4Chg oWFModelVo4Chg = getWFModelByModelId(strWFModelId);
        if (null == oWFModelVo4Chg) {
            return new ArrayList<>();
        }

        //get lstWFModelStepVo4Chg
        List<WFModelStepVo4Chg> lstWFModelStepVo4Chg = getWFModelStep(oWFModelVo4Chg);
        return lstWFModelStepVo4Chg;
    }

    private WFModelVo4Chg getWFModelByModelKey(String strWFModelKey) {
        //find oProcessDefinition by strWFModelKey
        ProcessDefinition oProcessDefinition = this.repositoryService.
                createProcessDefinitionQuery().processDefinitionKey(strWFModelKey).
                singleResult();
        if (null == oProcessDefinition) {
            return null;
        }

        //OutVo
        WFModelVo4Chg oNew = new WFModelVo4Chg();
        oNew.setId(oProcessDefinition.getId());
        oNew.setKey(oProcessDefinition.getKey());
        oNew.setName(oProcessDefinition.getName());
        oNew.setDesc(oProcessDefinition.getDescription());

        return oNew;
    }

    private WFModelVo4Chg getWFModelByModelId(String strWFModelId) {
        //find oProcessDefinition by strWFModelId
        ProcessDefinition oProcessDefinition = this.repositoryService.
                createProcessDefinitionQuery().processDefinitionId(strWFModelId).
                singleResult();
        if (null == oProcessDefinition) {
            return null;
        }

        //OutVo
        WFModelVo4Chg oNew = new WFModelVo4Chg();
        oNew.setId(oProcessDefinition.getId());
        oNew.setKey(oProcessDefinition.getKey());
        oNew.setName(oProcessDefinition.getName());
        oNew.setDesc(oProcessDefinition.getDescription());

        return oNew;
    }

    private List<WFModelStepVo4Chg> getWFModelStep(WFModelVo4Chg oWFModelVo4Chg) {
        List<WFModelStepVo4Chg> lstRes = new ArrayList<>();

        //get oBpmnModel
        BpmnModel oBpmnModel = this.repositoryService.getBpmnModel(oWFModelVo4Chg.getId());

        //get all elements
        Collection<FlowElement> lstFlowElement = oBpmnModel.getMainProcess().getFlowElements();

        //OutVo
        WFModelStepVo4Chg oParallelWFModelStepVo4Chg = null;
        for (FlowElement oFlowElement : lstFlowElement) {
            //UserTask
            if (oFlowElement instanceof UserTask) {
                WFModelStepVo4Chg oNew = new WFModelStepVo4Chg();
                oNew.setId(oFlowElement.getId());
                oNew.setName(oFlowElement.getName());
                oNew.setUiCompName(((UserTask) oFlowElement).getFormKey());
                if (oParallelWFModelStepVo4Chg == null) {
                    lstRes.add(oNew);
                } else {
                    oParallelWFModelStepVo4Chg.getLstWFModelStepVo4Chg().add(oNew);
                }
            }
            //ParallelGateway
            else if (oFlowElement instanceof ParallelGateway) {
                if (oParallelWFModelStepVo4Chg == null) {
                    oParallelWFModelStepVo4Chg = new WFModelStepVo4Chg();
                    oParallelWFModelStepVo4Chg.setId(oFlowElement.getId());
                    oParallelWFModelStepVo4Chg.setName(oFlowElement.getName());
                } else {
                    lstRes.add(oParallelWFModelStepVo4Chg);
                    oParallelWFModelStepVo4Chg = null;
                }
            }
        }

        return lstRes;
    }

    //#endregion

    //#region uiWF

    //#endregion

    //#region mopWF

    //#endregion

    //#region algWF

    //#endregion
}
