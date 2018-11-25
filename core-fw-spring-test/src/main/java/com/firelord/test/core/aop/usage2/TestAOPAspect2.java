package com.firelord.test.core.aop.usage2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class TestAOPAspect2 {
    //#region pointCut

    @Pointcut("execution(public * com.firelord.test.core.aop.usage2.TestAOPService.test(..))")
    public void pointCut() {

    }

    //#endregion

    //#region before

    @Before("pointCut() && args(strInput)")
    public void before(JoinPoint oJoinPoint, String strInput) {
        Object[] arrArgs = oJoinPoint.getArgs();
        System.out.println("TestAOPAspect2.before");
    }

    //#endregion

    //#region after

    @After("pointCut()")
    public void after() {
        System.out.println("TestAOPAspect2.after");
    }

    //#endregion

    //#region afterReturning

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("TestAOPAspect2.afterReturning");
    }

    //#endregion

    //#region afterThrowing

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("TestAOPAspect2.afterThrowing");
    }

    //#endregion

    //#region around(?暂时不用)

//    @Around("pointCut()")
//    public void around(ProceedingJoinPoint oJoinPoint) throws Throwable {
//        System.out.println("TestAOPAspect2.around");
//        oJoinPoint.proceed();
//        System.out.println("TestAOPAspect2.around");
//    }

    //#endregion
}
