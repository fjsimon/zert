package com.fjsimon.zert.review;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BearOrSharkTest {

    @Test
    public void test(){
        assertThat(BearOrShark.getResult(), is("BearShark"));
    }
}