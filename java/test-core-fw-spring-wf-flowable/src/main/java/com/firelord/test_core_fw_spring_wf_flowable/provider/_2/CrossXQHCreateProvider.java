package com.firelord.test_core_fw_spring_wf_flowable.provider._2;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CrossXQHCreateProvider implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("CrossXQHCreate...");
        delegateExecution.setVariable("a", "1");
    }
}