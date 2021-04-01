package com.vitaliy.spring.config;

import com.vitaliy.spring.beans3.BeanD;
import com.vitaliy.spring.beans3.BeanF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.vitaliy.spring.beans2"})
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
