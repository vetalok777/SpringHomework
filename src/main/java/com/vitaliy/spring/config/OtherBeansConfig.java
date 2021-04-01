package com.vitaliy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"com.vitaliy.spring.otherBeans"})
public class OtherBeansConfig {
}
