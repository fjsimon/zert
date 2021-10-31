package com.fjsimon.zert.inheritance;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Beta extends Baap {

    public int h = 44;

    public int getH() {
//        System.out.println("Beta " + h);
        return h;
    }


}
