package com.vitaliy.homework2.beans;


import com.vitaliy.homework2.Type;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public class BeanA implements InitializingBean, DisposableBean, Type {
    private String name;
    private int value;


    public BeanA() {
    }

    @Value("Jack")
    public void setName(String name) {
        this.name = name;
    }

    @Value("-10")
    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "BeanA { Name is " + name + ", value is " + value + " }";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanA -> Inside DisposableBean.destroy()");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanA -> Inside InitializingBean.afterPropertiesSet()");
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
