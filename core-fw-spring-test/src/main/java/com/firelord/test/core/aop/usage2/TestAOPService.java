package com.firelord.test.core.aop.usage2;

import org.springframework.stereotype.Service;

@Service
public class TestAOPService {
    public String test(String strInput) {
        String strRes = strInput + "...";
        return strRes;
    }
}
