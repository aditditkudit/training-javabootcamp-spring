package com.tavs.bootcamp.springboottrainingtelkom2019.di;

import org.springframework.stereotype.Component;

@Component
public class ClassC {
    private ClassD d;

    public ClassC(ClassD d) {
        this.d = d;
    }

    public ClassD getD() {
        return d;
    }

    public void setD(ClassD d) {
        this.d = d;
    }
}
