package com.firelord.j2se;

public class ClassA extends ClassB {
    public int num = 3;
    public ClassA(){
        this.print();
        num = 4;
    }
    public void print(){
        System.out.println("ClassA.num:" + num);
    }
}
