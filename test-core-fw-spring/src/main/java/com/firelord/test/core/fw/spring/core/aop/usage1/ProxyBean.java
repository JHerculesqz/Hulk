package com.firelord.test.core.fw.spring.core.aop.usage1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {
    //#region Fields

    private Object target;
    private ProxyBeanInterceptor proxyBeanInterceptor;

    //#endregion

    //#region getProxyBean

    public static Object getProxyBean(Object target, ProxyBeanInterceptor proxyBeanInterceptor) {
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.proxyBeanInterceptor = proxyBeanInterceptor;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                proxyBean);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        boolean exceptionFlag = false;

        //new ProxyBeanContext
        ProxyBeanContext oProxyBeanContext = new ProxyBeanContext(target, method, args);

        Object retObj = null;
        try {
            //before
            this.proxyBeanInterceptor.before(oProxyBeanContext);

            //around
            if (this.proxyBeanInterceptor.isAround()) {
                retObj = this.proxyBeanInterceptor.around(oProxyBeanContext);
            }
            //not around
            else {
                retObj = method.invoke(target, args);
            }

            //after
            this.proxyBeanInterceptor.after(oProxyBeanContext);
        } catch (Exception ex) {
            exceptionFlag = true;
        }

        //afterThrowing
        if (exceptionFlag) {
            this.proxyBeanInterceptor.afterThrowing(oProxyBeanContext);
            return null;
        }
        //afterReturning
        else {
            this.proxyBeanInterceptor.afterReturning(oProxyBeanContext);
            return retObj;
        }
    }

    //#endregion
}
