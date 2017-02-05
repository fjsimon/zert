package com.oca.exam.review;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SnippetTest {

    @Test
    public void test(){
        assertThat(Snippet.catchException(), is("abcde"));
    }
}