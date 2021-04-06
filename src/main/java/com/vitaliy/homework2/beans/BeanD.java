package com.vitaliy.homework2.beans;

import com.vitaliy.homework2.Type;

public class BeanD implements Type {
    private String name;
    private int value;

    public BeanD(String name, int value) {
        this.name = name;
        this.value = value;
    }


@Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@Override
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void customInitMethod() {
        System.out.println("BeanD -> Inside customInitMethod");
    }

    public void customDestroyMethod() {
        System.out.println("BeanD -> Inside customDestroyMethod");
    }

    @Override
    public String toString() {
        return "BeanD { Name is " + name + ", value is " + value + " }";
    }


}
