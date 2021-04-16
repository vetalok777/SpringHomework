package com.vitaliy.homework1.config;

import com.vitaliy.homework1.beans3.BeanD;
import com.vitaliy.homework1.beans3.BeanF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.vitaliy.homework1.beans2"})
@Configuration
public class AppConfig2 {

    @Bean("beanD")
    public BeanD getBeanD() {
        return new BeanD();
    }


    @Bean("beanF")
    public BeanF getBeanF() {
        return new BeanF();
    }
}
