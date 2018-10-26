package com.firelord.core.aop.usage1;


import java.lang.reflect.InvocationTargetException;

public interface ProxyBeanInterceptor {
    void before(ProxyBeanContext oProxyBeanContext);

    boolean isAround();

    Object around(ProxyBeanContext oProxyBeanContext) throws InvocationTargetException, IllegalAccessException;

    void after(ProxyBeanContext oProxyBeanContext);

    void afterThrowing(ProxyBeanContext oProxyBeanContext);

    void afterReturning(ProxyBeanContext oProxyBeanContext);
}
