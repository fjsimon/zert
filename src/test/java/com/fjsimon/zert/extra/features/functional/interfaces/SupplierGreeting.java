package com.fjsimon.zert.extra.features.functional.interfaces;

import java.util.function.Supplier;

public class SupplierGreeting implements Supplier<HelloWorld> {

    @Override
    public HelloWorld get() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setGreeting("Custom Hello World!");
        return helloWorld;
    }
}
