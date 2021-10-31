package com.fjsimon.zert.methods.staticmethod;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

public class StaticMethodTest extends BaseTest {

    @Test
    public void staticMethodTest() {

        Greeting customGreeting = new CustomGreeting();
        customGreeting.setName("Fran");
        System.out.println(customGreeting.getGreeting());
    }
}