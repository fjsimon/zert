package com.oca.exam.core;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class InstantExamplesTest {

    @Test
    public void getInstant(){
        assertThat(InstantExamples.getInstant(), is(not(nullValue())));
    }
}