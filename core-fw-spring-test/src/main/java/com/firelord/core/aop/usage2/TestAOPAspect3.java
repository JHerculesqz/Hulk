package com.firelord.core.aop.usage2;

import org.aspectj.lang.annotation.DeclareParents;

//TODO:[?]暂时不用
//@Component
//@Aspect
//@Order(1)
public class TestAOPAspect3 {
    //#region Fields

    @DeclareParents(value = "com.firelord.core.aop.usage2.TestAOPService+",
            defaultImpl = TestServiceAdvImpl.class)
    public TestServiceAdv testServiceAdv;

    //#endregion
}
