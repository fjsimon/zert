package com.fjsimon.zert.operations;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ChangeTestQ29 extends BaseTest {

    private int myValue = 0;

    public void showOne(int myValue) {
        myValue = myValue;
    }

    public void showTwo(int myValue) {
        this.myValue = myValue;
    }

    @Test
    public void changeTestQ29() {

        ChangeTestQ29 ct = new ChangeTestQ29();
        ct.showOne(100);
        System.out.println(ct.myValue);
        assertThat(ct.myValue, is(0));

        ct.showTwo(200);
        System.out.println(ct.myValue);
        assertThat(ct.myValue, is(200));
    }
}