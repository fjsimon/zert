package com.fjsimon.zert.core;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ObjectExamplesTest extends BaseTest {

    @Test
    public void convertingString() {


        assertThat(Boolean.parseBoolean("true"), instanceOf(Boolean.class));
        assertThat(Boolean.valueOf("TRUE"), instanceOf(Boolean.class));

        assertThat(Byte.parseByte("1"), instanceOf(Byte.class));
        assertThat(Byte.valueOf("2"), instanceOf(Byte.class));

        assertThat(Short.parseShort("1"), instanceOf(Short.class));
        assertThat(Short.valueOf("2"), instanceOf(Short.class));

        assertThat(Integer.parseInt("1"), instanceOf(Integer.class));
        assertThat(Integer.valueOf("2"), instanceOf(Integer.class));

        assertThat(Long.parseLong("1"), instanceOf(Long.class));
        assertThat(Long.valueOf("2"), instanceOf(Long.class));

        assertThat(Float.parseFloat("2.2"), instanceOf(Float.class));
        assertThat(Float.valueOf("2.2"), instanceOf(Float.class));

        assertThat(Double.parseDouble("2.2"), instanceOf(Double.class));
        assertThat(Double.valueOf("2"), instanceOf(Double.class));
    }

    @Test
    public void autoboxing() {

        List<Double> weights = new ArrayList<>();
        weights.add(50.5);
        weights.add(new Double(60));
        weights.remove(50.5);
        double first = weights.get(0);
        assertThat(first, is(60.0));
        assertThat(first, instanceOf(Double.class));
    }

    @Test
    public void autoboxing_exception() {

        List<Integer> heights = new ArrayList<>();
        heights.add(null);

        exception.expect(NullPointerException.class);
        int h = heights.get(0); // NullPointerException
    }

    @Test
    public void autoboxing_removing() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.remove(1);

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(1);
        numbers2.add(2);
        numbers2.remove(new Integer(1));

        assertThat(numbers.toString(), is("[1]"));
        assertThat(numbers2.toString(), is("[2]"));
    }
}
