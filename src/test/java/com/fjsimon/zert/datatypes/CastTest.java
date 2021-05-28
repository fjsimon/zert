package com.fjsimon.zert.datatypes;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CastTest {

    @Test
    public void castTest() {

        byte b = -128 ;
        int i = b ;
        b = (byte) i;
        System.out.println(i+" "+b);
        assertThat(i==b, is(true));
    }
}
