package com.fjsimon.zert.extra.features.lambda;

import org.junit.Test;

public class RefactoringCodeTest {

    public static void process(Hello h) {

        h.printGreeting(2);
    }

    abstract static class HelloWorld {

        public abstract void printGreeting();
    }

    @Test
    public void anonymousClassTest() {

        // anonymous class
        process(new Hello() {
            @Override
            public void printGreeting(int count) {
                for (int i = 0; i < count; i++) {
                    System.out.println("ANONYMOUS: Hello World " + i);
                }
            }
        });
    }

    @Test
    public void lambdaExpressionTest() {

        // refactor to lambda expression
        process((int count) -> {
            for (int i = 0; i < count; i++) {
                System.out.println("LAMBDA: Hello World " + i);
            }
        });
    }

    @Test
    public void anonymousClassExampleTest() {

        HelloWorld helloWorld = new HelloWorld() {
            @Override
            public void printGreeting() {
                System.out.println("ANONYMOUS: Hello World!");
            }
        };
        helloWorld.printGreeting();
    }
}
