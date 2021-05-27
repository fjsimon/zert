package com.fjsimon.zert.extra.features.method.enhancements;

import static java.lang.String.format;

public class DefaultMethodsExample {

    public static void main(String... args) {

        DefaultGreeting defaultGreeting = new DefaultGreeting() {
            @Override
            public String getGreeting(String name) {
                return format(getTemplate(), name);
            }
        };
        System.out.println("Default greeting: " + defaultGreeting.getGreeting("Fr@n"));

        UpperCaseGreeting upperCaseGreeting = new UpperCaseGreeting() {
            @Override
            public String getGreeting(String name) {

                return format(getTemplate(), name);
            }

            @Override
            public String getGreetingInUpperCase(String name) {

                return getGreeting(name).toUpperCase();
            }
        };
        System.out.println("\nUpper case greeting: " + upperCaseGreeting.getGreetingInUpperCase("Fr@n"));

        DefaultGreeting abstractGreeting = new AbstractGreeting() {
            @Override
            public String getTemplate() {

                return "Abstract hello, %s!";
            }

            @Override
            public String getGreeting(String name) {

                return format(getTemplate(), name);
            }
        };
        System.out.println("\nAbstract greeting: " + abstractGreeting.getGreeting("Fr@n"));

        DefaultGreeting overriddenGreeting = new OverriddenGreeting() {
            @Override
            public String getGreeting(String name) {
                return format(getTemplate(), name);
            }
        };
        System.out.println("\nOverridden greeting: " + overriddenGreeting.getGreeting("Fr@n"));
    }
}

interface DefaultGreeting {

    String getGreeting(String name);

    // default method in question
    default String getTemplate() {

        return "Hello, %s!";
    }
}
// Inheritance rules when extending interfaces that contain default methods:

// 1) Not mention the default method at all, which lets your extended interface inherit the default method.
interface UpperCaseGreeting extends DefaultGreeting {

    String getGreetingInUpperCase(String name);
}

// 2) Redeclare the default method, which makes it abstract.
interface AbstractGreeting extends DefaultGreeting {

    String getTemplate();
}

// 3) Redefine the default method, which overrides it.
interface OverriddenGreeting extends DefaultGreeting {

    @Override
    default String getTemplate() {

        return "Overridden hello to you, %s!";
    }
}
