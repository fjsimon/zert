package com.oca.exam.extra.features.functional.interfaces;

import java.util.function.Supplier;

public class CustomGreetingSupplier implements Supplier<HelloWorld> {

    @Override
    public HelloWorld get() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setGreeting("Custom Hello World!");
        return helloWorld;
    }
}
