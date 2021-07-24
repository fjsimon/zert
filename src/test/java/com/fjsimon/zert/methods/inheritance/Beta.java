package com.fjsimon.zert.methods.inheritance;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Beta extends Baap {

    public int h = 44;

    public int getH() {
//        System.out.println("Beta " + h);
        return h;
    }

    @Test
    public void inheritanceTest() {

        Baap b = new Beta();
//        System.out.println(b.h + " " + b.getH());
        assertThat(b.h, is(4));
        assertThat(b.getH(), is(44));

        Beta bb = (Beta) b;
//        System.out.println(bb.h + " " + bb.getH());
        assertThat(bb.h, is(44));
        assertThat(bb.getH(), is(44));
    }
}
