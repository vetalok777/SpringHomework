package com.vitaliy.homework2.config;


import com.vitaliy.homework2.beans.BeanA;
import com.vitaliy.homework2.beans.BeanE;
import com.vitaliy.homework2.beans.BeanF;
import com.vitaliy.homework2.beans.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig2 {


    @Bean
    public BeanA getBeanA() {
        System.out.println("Inside getBeanA");
        return new BeanA();
    }


    @Bean
    public BeanE getBeanE() {
        System.out.println("Inside getBeanE");
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF getBeanF(){
        System.out.println("BeanF -> Inside bean with Lazy annotation");
        return new BeanF();
    }

    @Bean
    public static MyBeanPostProcessor getBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

}
