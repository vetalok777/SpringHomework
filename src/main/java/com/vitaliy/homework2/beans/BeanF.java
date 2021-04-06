package com.vitaliy.homework2.beans;

import com.vitaliy.homework2.Type;
import org.springframework.beans.factory.annotation.Value;

public class BeanF implements Type {
    private String name;
    private int value;

    @Value("Tom")
    public void setName(String name) {
        this.name = name;
    }

    @Value("-1")
    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "BeanF { Name is " + name + ", value is " + value + " }";
    }
}
