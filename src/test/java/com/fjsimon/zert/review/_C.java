package com.fjsimon.zert.review;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class _C {

    private static int $;

    @Test
    public void test(){
        String a_b;
        System.out.print($);
        assertThat($, is(0));

        // System.out.print(a_b); // Compile error. it has not been initialized
    }
}
