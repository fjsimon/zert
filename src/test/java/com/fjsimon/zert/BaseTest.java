package com.fjsimon.zert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

public class BaseTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }
}
