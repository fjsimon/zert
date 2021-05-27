package com.fjsimon.zert.extra.features.method.enhancements;

import static java.lang.String.format;

public class StaticMethodsExample {

    public static void main(String... args) {

        Greeting customGreeting = new CustomGreeting();
        customGreeting.setName("Fran");
        System.out.println(customGreeting.getGreeting());
    }
}

interface Greeting {

    void setName(String name);

    String getGreeting();

    // static method in question
    static String getTemplate() {

        return "Hello, %s!";
    }
}

class CustomGreeting implements Greeting {

    private String name;

    @Override
    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String getGreeting() {

        return format(Greeting.getTemplate(), name);
    }
}