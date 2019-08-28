package com.tavs.bootcamp.springboottrainingtelkom2019.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClassF {
    @Value("Kudit Cogan Binggow")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
