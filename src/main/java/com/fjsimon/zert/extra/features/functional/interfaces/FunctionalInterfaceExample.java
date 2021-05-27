package com.fjsimon.zert.extra.features.functional.interfaces;


public class FunctionalInterfaceExample {

    public static void process(Hello h) {

        h.printGreeting();
    }

    public static void main(String... args) {

        Hello hw1 = () -> System.out.println("Hello World 1!");

        Hello hw2 = new Hello() {
            @Override
            public void printGreeting() {

                System.out.println("Hello World 2!");
            }
        };

        process(hw1);
        process(hw2);
        process(() -> System.out.println("Hello World 3!"));
    }

}
