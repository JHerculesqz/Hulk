package com.firelord.test.core.fw.spring.core.aop.usage1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyBeanContext {
    //#region Fields

    private Object target;
    private Method method;
    private Object[] params;

    //#endregion

    //#region Construction

    public ProxyBeanContext(Object target, Method method, Object[] params) {
        this.target = target;
        this.method = method;
        this.params = params;
    }

    //#endregion

    //#region run

    public Object run() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(this.target, this.params);
    }

    //#endregion
}
