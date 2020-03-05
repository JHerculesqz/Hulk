package com.firelord.test.core.fw.spring.core.aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
@Order(3)
public class LogAspect {
    //#region pointCut

    @Pointcut("execution(public * com.firelord.test.core.fw.spring.core.aop.usage2..*.*(..))")
    public void pointCut() {

    }

    //#endregion

    //#region before

    @Before("pointCut()")
    public void before(JoinPoint oJoinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + oJoinPoint.getSignature().getDeclaringTypeName() +
                "." + oJoinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(oJoinPoint.getArgs()));
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
