package com.tavs.bootcamp.springboottrainingtelkom2019.di;

public class ClassA {
    private ClassB b;

    public ClassA(ClassB b) {
        this.b = b;
    }

    public ClassB getB() {
        return b;
    }

    public void setB(ClassB b) {
        this.b = b;
    }
}
