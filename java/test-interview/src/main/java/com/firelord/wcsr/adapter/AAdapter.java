package com.firelord.wcsr.adapter;

public class AAdapter {
    public Object fun(Object oB, Object oArg){
        if(oB instanceof B1Adapter){
            return ((B1Adapter)oB).func1((Integer) oArg);
        }
        else if(oB instanceof B2Adapter){
            return ((B2Adapter)oB).func2((Double) oArg);
        }
        else{
            return null;
        }
    }
}
