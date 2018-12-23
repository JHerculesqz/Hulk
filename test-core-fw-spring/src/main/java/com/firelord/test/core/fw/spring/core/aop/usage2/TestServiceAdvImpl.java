package com.firelord.test.core.fw.spring.core.aop.usage2;

public class TestServiceAdvImpl implements TestServiceAdv {
    //#region adv

    @Override
    public void adv() {
        System.out.println("TestServiceAdvImpl.adv...");
    }

    //#endregion
}
