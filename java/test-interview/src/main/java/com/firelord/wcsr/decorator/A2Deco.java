package com.firelord.wcsr.decorator;

public class A2Deco implements IBDeco {
    private IBDeco b;

    public A2Deco(IBDeco oB){
        this.b = oB;
    }

    @Override
    public String cost() {
        return "A2" + b.cost();
    }
}
