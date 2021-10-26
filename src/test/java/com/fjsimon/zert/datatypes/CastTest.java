package com.fjsimon.zert.datatypes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CastTest {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void castTest() {

        byte b = -128 ;
        int i = b ;
        b = (byte) i;
        System.out.println(i+" "+b);
        assertThat(i==b, is(true));
    }
}
