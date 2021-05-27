package com.fjsimon.zert.review;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayListExampleTest {

    @Test
    public void test(){
        assertThat(ArrayListExample.getResult(), is(CoreMatchers.instanceOf(List.class)));
        assertThat(ArrayListExample.getResult().toString(), is("[9]"));
    }
}