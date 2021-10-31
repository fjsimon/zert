package com.fjsimon.zert.methods.enhancements;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DefaultMethodsExampleTest extends BaseTest {

    @Test
    public void defaultGreetingTest() {
        DefaultGreeting
                defaultGreeting = new DefaultGreeting() {
            @Override
            public String getGreeting(String name) {
                return format(getTemplate(), name);
            }
        };
        System.out.println("Default greeting: " + defaultGreeting.getGreeting("Fr@n"));

        assertThat( defaultGreeting.getGreeting("Fr@n"), is("Hello, Fr@n!"));
    }

    @Test
    public void upperCaseGreetingTest() {

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

        assertThat( upperCaseGreeting.getGreetingInUpperCase("Fr@n"), is("HELLO, FR@N!"));

    }

    @Test
    public void abstractGreetingTest() {

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

        assertThat( abstractGreeting.getGreeting("Fr@n"), is("Abstract hello, Fr@n!"));
    }

    @Test
    public void overridenGreetingTest() {

        DefaultGreeting overriddenGreeting = new OverriddenGreeting() {
            @Override
            public String getGreeting(String name) {
                return format(getTemplate(), name);
            }
        };
        System.out.println("\nOverridden greeting: " + overriddenGreeting.getGreeting("Fr@n"));

        assertThat( overriddenGreeting.getGreeting("Fr@n"), is("Overridden hello to you, Fr@n!"));
    }
}
