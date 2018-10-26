package com.firelord.core.aop.usage2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class TestAOPAspect1 {
    //#region pointCut

    @Pointcut("execution(public * com.firelord.core.aop.usage2.TestAOPService.test(..))")
    public void pointCut() {

    }

    //#endregion

    //#region before

    @Before("pointCut() && args(strInput)")
    public void before(JoinPoint oJoinPoint, String strInput) {
        Object[] arrArgs = oJoinPoint.getArgs();
        System.out.println("TestAOPAspect1.before");
    }

    //#endregion

    //#region after

    @After("pointCut()")
    public void after() {
        System.out.println("TestAOPAspect1.after");
    }

    //#endregion

    //#region afterReturning

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("TestAOPAspect1.afterReturning");
    }

    //#endregion

    //#region afterThrowing

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("TestAOPAspect1.afterThrowing");
    }

    //#endregion

    //#region around(?暂时不用)

//    @Around("pointCut()")
//    public void around(ProceedingJoinPoint oJoinPoint) throws Throwable {
//        System.out.println("TestAOPAspect1.around");
//        oJoinPoint.proceed();
//        System.out.println("TestAOPAspect1.around");
//    }

    //#endregion
}
