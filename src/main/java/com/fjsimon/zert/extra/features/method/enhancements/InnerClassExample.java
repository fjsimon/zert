package com.fjsimon.zert.extra.features.method.enhancements;

public class InnerClassExample {

    private String greeting = "Hello World!";

    public void printGreeting() {

        System.out.println("OUTER: " + greeting);
    }

    class HelloWorld {

        public void printGreeting() {

            System.out.println("INNER: " + greeting);
        }
    }

    public static void main(String... args) {
        InnerClassExample innerClassExample = new InnerClassExample();
        innerClassExample.printGreeting();

        HelloWorld helloWorld = innerClassExample.new HelloWorld();
        helloWorld.printGreeting();
    }
}
