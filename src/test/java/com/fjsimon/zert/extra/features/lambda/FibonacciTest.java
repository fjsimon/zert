package com.fjsimon.zert.extra.features.lambda;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class FibonacciTest extends BaseTest {

    private Map<Integer, Integer> cache = new ConcurrentHashMap<>();

    public int get(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return cache.computeIfAbsent(n, key -> get(n - 2) + get(n - 1));
    }

    @Test
    public void fibonacci(){

        System.out.println("\nFirst 10 Fibonacci numbers: ");

        List<Integer> results = new ArrayList();
        IntStream.range(0, 10).forEach(x -> results.add(get(x)));
        results.forEach(System.out::println);

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