package com.fjsimon.zert.methods;

import org.junit.Test;

public class LocalMethodClassTest {

    private String greeting = "Hello World!";

    public void printGreeting() {

        class HelloWorld {

            public void printGreeting() {
                System.out.println("LOCAL METHOD: " + greeting);
            }
        }
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.printGreeting();
    }

    @Test
    public void localMethodClassTest() {

        new LocalMethodClassTest().printGreeting();
    }
}
