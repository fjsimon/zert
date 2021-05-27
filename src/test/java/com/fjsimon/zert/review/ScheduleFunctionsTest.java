package com.fjsimon.zert.review;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScheduleFunctionsTest {

    @Test
    public void getFirstResult(){

        assertThat(ScheduleFunctions.getFirstResult(), is(6));
    }

    @Test
    public void getSecondResult(){

        assertThat(ScheduleFunctions.getSecondResult(), is(12));
    }
}