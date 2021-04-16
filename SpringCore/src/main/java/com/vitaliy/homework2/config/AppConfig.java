package com.vitaliy.homework2.config;

import com.vitaliy.homework2.beans.BeanB;
import com.vitaliy.homework2.beans.BeanC;
import com.vitaliy.homework2.beans.BeanD;

import com.vitaliy.homework2.beans.MyBeanFactoryPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;


@Configuration
@Import(AppConfig2.class)
@PropertySource("classpath:application.properties")
public class AppConfig {


    @Autowired
    Environment env;


    @Bean(initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod")
    @DependsOn({"getBeanD"})
    public BeanB getBeanB() {
        System.out.println("Inside getBeanB");
        return new BeanB(env.getProperty("beanB.name"), Integer.parseInt(env.getProperty("beanB.value")));

    }

    @Bean(initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod")
    @DependsOn({"getBeanB"})
    public BeanC getBeanC() {
        System.out.println("Inside getBeanC");
        return new BeanC(env.getProperty("beanC.name"), Integer.parseInt(env.getProperty("beanC.value")));
    }

   @Bean(initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod")
    public BeanD getBeanD() {
        System.out.println("Inside getBeanD");
        return new BeanD(env.getProperty("beanD.name"), Integer.parseInt(env.getProperty("beanD.value")));
    }

    @Bean
    public static MyBeanFactoryPostProcessor getFacPostProc(){
        return new MyBeanFactoryPostProcessor();
    }
}
