package com.firelord.wcsr.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class A1Proxy {
    //#region Fields

    private Object b;

    //#endregion

    //#region createProxyObj

    public Object createProxyObj(Object oB) {
        this.b = oB;

        return Proxy.newProxyInstance(b.getClass().getClassLoader(),
                b.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("func1")) {
                            System.out.println("hack before...");
                            Object result = method.invoke(b, args);
                            return result;
                        } else {
                            return null;
                        }
                    }
                });
    }

    //#endregion
}
