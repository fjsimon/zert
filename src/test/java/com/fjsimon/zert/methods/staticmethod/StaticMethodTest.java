package com.fjsimon.zert.methods.staticmethod;

import org.junit.Test;

public class StaticMethodTest {

    @Test
    public void staticMethodTest() {

        Greeting customGreeting = new CustomGreeting();
        customGreeting.setName("Fran");
        System.out.println(customGreeting.getGreeting());
    }
}