package com.oca.exam.extra.features.lambda;

public class RefactoringCodeExample {

    public static void process(Hello h) {

        h.printGreeting(2);
    }

    public static void main(String... args) {

        // anonymous class
        process(new Hello() {
            @Override
            public void printGreeting(int count) {
                for (int i = 0; i < count; i++) {
                    System.out.println("ANONYMOUS: Hello World " + i);
                }
            }
        });

        // refactor to lambda expression
        process((int count) -> {
            for (int i = 0; i < count; i++) {
                System.out.println("LAMBDA: Hello World " + i);
            }
        });
    }
}
