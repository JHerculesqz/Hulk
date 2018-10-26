package com.firelord.core.aop.usage1;

import java.lang.reflect.InvocationTargetException;

public class TestInterceptor implements ProxyBeanInterceptor {
    //#region before

    @Override
    public void before(ProxyBeanContext oProxyBeanContext) {
        System.out.println("before");
    }

    //#endregion

    //#region around

    @Override
    public boolean isAround() {
        return false;
    }

    @Override
    public Object around(ProxyBeanContext oProxyBeanContext) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around start");
        Object oRes = oProxyBeanContext.run();
        System.out.println("around end");
        return oRes;
    }

    //#endregion

    //#region after

    @Override
    public void after(ProxyBeanContext oProxyBeanContext) {
        System.out.println("after");
    }

    //#endregion

    //#region afterThrowing

    @Override
    public void afterThrowing(ProxyBeanContext oProxyBeanContext) {
        System.out.println("afterThrowing");
    }

    //#endregion

    //#region afterReturning

    @Override
    public void afterReturning(ProxyBeanContext oProxyBeanContext) {
        System.out.println("afterReturning");
    }

    //#endregion
}
