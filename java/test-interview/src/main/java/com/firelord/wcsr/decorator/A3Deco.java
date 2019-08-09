package com.firelord.wcsr.decorator;

public class A3Deco implements IBDeco {
    private IBDeco b;

    public A3Deco(IBDeco oB){
        this.b = oB;
    }

    @Override
    public String cost() {
        return "A3" + b.cost();
    }
}
