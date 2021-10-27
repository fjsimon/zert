package com.fjsimon.zert.datatypes;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CastTest extends BaseTest {

    @Test
    public void castTest() {

        byte b = -128 ;
        int i = b ;
        b = (byte) i;
        System.out.println(i+" "+b);
        assertThat(i==b, is(true));
    }
}
