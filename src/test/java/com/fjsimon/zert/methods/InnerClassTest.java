package com.fjsimon.zert.methods;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

public class InnerClassTest extends BaseTest {

    private String greeting = "Hello World!";

    public void printGreeting() {

        System.out.println("OUTER: " + greeting);
    }

    class HelloWorld {

        public void printGreeting() {

            System.out.println("INNER: " + greeting);
        }
    }

    @Test
    public void innerClassTest() {
        InnerClassTest innerClass = new InnerClassTest();
        innerClass.printGreeting();

        InnerClassTest.HelloWorld helloWorld = innerClass.new HelloWorld();
        helloWorld.printGreeting();
    }
}
