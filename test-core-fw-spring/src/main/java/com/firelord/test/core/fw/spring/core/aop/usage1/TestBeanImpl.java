package com.firelord.test.core.fw.spring.core.aop.usage1;

public class TestBeanImpl implements TestBean {
    public String test(String strInput) {
        System.out.println(strInput);
        return "return value";
    }
}
