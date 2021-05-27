package com.fjsimon.zert.extra.features.functional.interfaces;

import java.util.function.Supplier;

public class SupplierInterfaceExample {

    public static void printGreeting(Supplier<HelloWorld> supplier) {
        System.out.println(supplier.get().getGreeting());
    }

    public static void main(String... args) {

        Supplier<HelloWorld> supplier = HelloWorld::new;
        printGreeting(supplier);
        printGreeting(() -> new HelloWorld());
        printGreeting(new CustomGreetingSupplier());
    }

}
