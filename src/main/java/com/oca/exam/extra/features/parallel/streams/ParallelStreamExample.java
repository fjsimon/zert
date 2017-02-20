package com.oca.exam.extra.features.parallel.streams;

import java.util.stream.IntStream;


public class ParallelStreamExample {
    public static void main(String... args) {

        int minValue = 1;
        int maxValue = 100_000;
        long sum = IntStream.range(minValue, maxValue)
                .parallel()
                .sum();
        System.out.printf("Sum[%d, %d]: %d", minValue, maxValue, sum);
    }
}
