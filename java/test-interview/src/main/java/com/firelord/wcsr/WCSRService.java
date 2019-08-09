package com.firelord.wcsr;

import com.firelord.wcsr.adapter.AAdapter;
import com.firelord.wcsr.adapter.B1Adapter;
import com.firelord.wcsr.adapter.B2Adapter;
import com.firelord.wcsr.decorator.A1Deco;
import com.firelord.wcsr.decorator.A2Deco;
import com.firelord.wcsr.decorator.A3Deco;
import com.firelord.wcsr.decorator.IBDeco;
import com.firelord.wcsr.observ.IObserver;
import com.firelord.wcsr.observ.Observer1;
import com.firelord.wcsr.observ.Observer2;
import com.firelord.wcsr.observ.Subject;
import com.firelord.wcsr.proxy.A1Proxy;
import com.firelord.wcsr.proxy.A2Proxy;
import com.firelord.wcsr.proxy.BProxy;
import com.firelord.wcsr.proxy.IBProxy;
import com.firelord.wcsr.singleton.Singleton1;
import com.firelord.wcsr.singleton.Singleton2;
import com.firelord.wcsr.singleton.Singleton31;
import com.firelord.wcsr.singleton.Singleton32;

public class WCSRService {
    //#region proxy

    public static void testProxy(){
        BProxy oB = new BProxy();
        A1Proxy oA1 = new A1Proxy();
        A2Proxy oA2 = new A2Proxy();

        IBProxy oIB1 = (IBProxy) oA1.createProxyObj(oB);
        String strRes1 = oIB1.func1("123");
        System.out.println(strRes1);

        IBProxy oIB2 = (IBProxy)oA2.createProxyObj(BProxy.class);
        String strRes2 = oIB2.func1("456");
        System.out.println(strRes2);
    }

    //#endregion

    //#region decorator

    public static void testDecorator(){
        IBDeco oC1 = new A1Deco();
        IBDeco oC2 = new A2Deco(oC1);
        IBDeco oC3 = new A3Deco(oC2);
        System.out.println(oC3.cost());
    }

    //#endregion

    //#region adapter

    public static void testAdapter(){
        B1Adapter oB1 = new B1Adapter();
        B2Adapter oB2 = new B2Adapter();
        AAdapter oA = new AAdapter();

        Object oRes1 = oA.fun(oB1, 1);
        System.out.println(oRes1);
        Object oRes2 = oA.fun(oB2, 1.1);
        System.out.println(oRes2);
    }

    //#endregion

    //#region singleton

    public static void testSingleton(){
        Singleton1.getInstance();
        Singleton2.getInstance();
        Singleton31.getInstance();
        Singleton32.getInstance();
    }

    //#endregion

    //#region observer

    public static void testObserver(){
        IObserver o1 = new Observer1();
        IObserver o2 = new Observer2();
        Subject oSubject = new Subject();
        oSubject.attach(o1);
        oSubject.attach(o2);
        oSubject.publish("test1");
        oSubject.detach(o1);
        oSubject.publish("test2");
    }

    //#endregion
}
