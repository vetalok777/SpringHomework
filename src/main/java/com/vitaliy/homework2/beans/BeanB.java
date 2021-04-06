package com.vitaliy.homework2.beans;


import com.vitaliy.homework2.Type;

public class BeanB implements Type {

    private String name;
    private int value;

    public BeanB(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public BeanB() {
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setValue(int value) {
        this.value = value;
    }


    public void customInitMethod() {
        System.out.println("BeanB -> Inside customInitMethod");
    }

    public void customDestroyMethod() {
        System.out.println("BeanB -> Inside customDestroyMethod");
    }



    @Override
    public String toString() {
        return "BeanB { Name is " + name + ", value is " + value + " }";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    public void init(){
        System.out.println("BeanB -> HELLO FROM CUSTOM INIT METHOD №2");
    }

}
