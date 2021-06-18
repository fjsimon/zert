package com.fjsimon.zert.extra.features.functional.interfaces;

import org.junit.Test;

import java.util.function.Supplier;

public class SupplierInterfaceExample {

    public static void printGreeting(Supplier<HelloWorld> supplier) {
        System.out.println(supplier.get().getGreeting());
    }

    @Test
    public void supplierPrintTest() {

        Supplier<HelloWorld> supplier = HelloWorld::new;
        printGreeting(supplier);

        printGreeting(() -> new HelloWorld());

        printGreeting(new SupplierGreeting());
    }

}
