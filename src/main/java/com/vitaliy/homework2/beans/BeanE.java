package com.vitaliy.homework2.beans;

import com.vitaliy.homework2.Type;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE implements Type {
    private String name;
    private int value;

    @Value("John")
    public void setName(String name) {
        this.name = name;
    }

    @Value("50")
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanE { Name is " + name + ", value is " + value + " }";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("BeanE -> Inside @PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Bean E -> Inside @PreDestroy");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
