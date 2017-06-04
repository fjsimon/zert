package com.oca.exam.core;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringBuilderExamplesTest {

    @Test
    public void getStringBuilderAppend(){

        assertThat(StringBuilderExamples.getStringBuilderAppend().toString(), is("Hello World"));
    }

    @Test
    public void getStringBuilderAppendIter() {

        assertThat(StringBuilderExamples.getStringBuilderAppendIter().toString(),
                is("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void getStringBuilderInsert(){

        assertThat(StringBuilderExamples.getStringBuilderInsert().toString(), is("HWorldello "));
    }
}