package com.oca.exam.extra.features.method.enhancements;

public class AnonymousClassExample {

    abstract static class HelloWorld {

        public abstract void printGreeting();
    }

    public static void main(String... args) {

        HelloWorld helloWorld = new HelloWorld() {
            @Override
            public void printGreeting() {
                System.out.println("ANONYMOUS: Hello World!");
            }
        };
        helloWorld.printGreeting();
    }
}
