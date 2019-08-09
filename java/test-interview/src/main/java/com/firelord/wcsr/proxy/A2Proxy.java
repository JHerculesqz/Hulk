package com.firelord.wcsr.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class A2Proxy {
    //#region createProxyObj

    public Object createProxyObj(Class<?> oClazz) {
        Enhancer oEnhancer = new Enhancer();
        oEnhancer.setSuperclass(oClazz);
        oEnhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("hack before...");
                return methodProxy.invokeSuper(o, objects);
            }
        });
        return oEnhancer.create();
    }

    //#endregion
}
