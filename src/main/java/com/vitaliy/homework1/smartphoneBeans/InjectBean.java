package com.vitaliy.homework1.smartphoneBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InjectBean {
    private Processor processor;
    private Processor processor1;
    private Processor processor2;

    @Autowired
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Autowired
    public void setProcessor1(@Qualifier("samsung") Processor processor1) {
        this.processor1 = processor1;
    }

    @Autowired
    public void setProcessor2(@Qualifier("huawei") Processor processor2) {
        this.processor2 = processor2;
    }
}
