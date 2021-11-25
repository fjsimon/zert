package com.fjsimon.zert.datatypes;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IntegerTest extends BaseTest {

    public static void op(Integer obj, int var) {

        System.out.printf("obj = %d, var = %d%n", obj, var);
        obj = var++;
        System.out.printf("obj = %d, var = %d%n", obj, var);
        obj++;
        System.out.printf("obj = %d, var = %d%n", obj, var);
    }

    @Test
    public void integer_test() {

        Integer val1 = new Integer(5);
        int val2 = 9;
        op(val1++, ++val2);
        System.out.printf("val1 = %d, val2 = %d%n", val1, val2);
    }

    @Test
    public void integer_equals_test() {

        Integer val1 = new Integer(5);
        Integer val2 = Integer.parseInt("5");
        System.out.printf("equals = %b %n", val1.equals(val2));
        System.out.printf("hasCode val1 = %d %n", val1.hashCode());
        System.out.printf("hasCode val2 = %d %n", val2.hashCode());
    }


    @Test
    public void integer_compareTo_test() {

        Integer val1 = new Integer(2);
        Integer val2 = new Integer(5);
        System.out.printf("compareTo = %d%n", val1.compareTo(val2));
        System.out.printf("compareTo = %d%n", val2.compareTo(val1));
        System.out.printf("compareTo = %d%n", val2.compareTo(val2));
    }

    @Test
    public void integer_array_equals_test() {

        Integer[] one = new Integer[10];
        Integer[] two = new Integer[10];
        assertThat(Arrays.equals(one, two), is(true));
        one[0] = 1;
        assertThat(Arrays.equals(one, two), is(false));
        two[0] = 1;
        assertThat(Arrays.equals(one, two), is(true));
        one[1] = 2;
        two[0] = 2;
        assertThat(Arrays.equals(one, two), is(false));
    }
}
