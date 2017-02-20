package com.oca.exam.extra.features.method.enhancements;

public class LocalMethodClassExample {

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

    public static void main(String... args) {
        new LocalMethodClassExample().printGreeting();
    }
}
