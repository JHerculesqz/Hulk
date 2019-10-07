package com.firelord.j2se;

public class ClassB{
    public int num = 1;

    public ClassB(){
        this.print();
        num = 2;
    }
    public void print(){
        System.out.println("ClassB.num:" + num);
    }
}
