package com.oca.exam.review;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MathFunctionsTest {

    @Test
    public void test(){
        assertThat(MathFunctions.getResult(), is(15));
    }
}