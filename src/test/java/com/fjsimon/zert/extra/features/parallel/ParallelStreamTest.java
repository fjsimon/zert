package com.fjsimon.zert.extra.features.parallel;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.stream.IntStream;

public class ParallelStreamTest {

    @Test
    public void parallel_stream_test() {

        int minValue = 1;
        int maxValue = 500_000_000;

        LocalTime before = LocalTime.now();

        long sum = IntStream.range(minValue, maxValue)
                .parallel()
                .sum();

        LocalTime after = LocalTime.now();
        Duration duration = Duration.between ( before, after );

        System.out.printf("Parallel Sum[%d, %d]: %d%n", minValue, maxValue, sum);
        System.out.printf("Parallel Duration: %s%n", duration );
    }

    @Test
    public void no_parallel_stream_test() {

        int minValue = 1;
        int maxValue = 500_000_000;

        LocalTime before = LocalTime.now();

        long sum = IntStream.range(minValue, maxValue)
                .sum();

        LocalTime after = LocalTime.now();
        Duration duration = Duration.between ( before, after );

        System.out.printf("Non Parallel Sum[%d, %d]: %d%n", minValue, maxValue, sum);
        System.out.printf("Non Parallel Duration: %s%n", duration );
    }
}
