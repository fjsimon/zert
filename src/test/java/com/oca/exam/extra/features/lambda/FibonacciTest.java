package com.oca.exam.extra.features.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FibonacciTest {

    @Test
    public void fibonacci(){

        Fibonacci fibonacci = new Fibonacci();
        System.out.print("\nFirst 10 Fibonacci numbers: ");

        List<Integer> results = new ArrayList();
        IntStream.range(0, 10).forEach(x -> results.add(fibonacci.get(x)));

        assertThat(results.get(0), is(0));
        assertThat(results.get(1), is(1));
        assertThat(results.get(2), is(1));
        assertThat(results.get(3), is(2));
        assertThat(results.get(4), is(3));
        assertThat(results.get(5), is(5));
        assertThat(results.get(6), is(8));
        assertThat(results.get(7), is(13));
        assertThat(results.get(8), is(21));
        assertThat(results.get(9), is(34));

    }
}