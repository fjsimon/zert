package com.fjsimon.zert.datatypes;

import org.junit.Test;

public class IntegerTest {

    public static void op(Integer obj, int var) {

        System.out.printf("obj = %d, var = %d%n", obj, var);
        obj = var++;
        System.out.printf("obj = %d, var = %d%n", obj, var);
        obj++;
        System.out.printf("obj = %d, var = %d%n", obj, var);
    }

    @Test
    public void integerTest() {

        Integer val1 = new Integer(5);
        int val2 = 9;
        op(val1++, ++val2);
        System.out.printf("val1 = %d, val2 = %d%n", val1, val2);
    }

}
