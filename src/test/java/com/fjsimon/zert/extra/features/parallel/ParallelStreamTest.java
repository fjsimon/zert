package com.fjsimon.zert.extra.features.parallel;

import com.fjsimon.zert.BaseTest;
import com.fjsimon.zert.common.FuturamaCharacter;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamTest extends BaseTest {

    private static final List<FuturamaCharacter> characters = Arrays.asList(
            new FuturamaCharacter("Bender", "Rodriguez", 5),
            new FuturamaCharacter("Philip", "Fry", 126),
            new FuturamaCharacter("Turanga", "Leela", 22));

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

    @Test
    public void reduction_sum_test() {

        System.out.println("Futurama characters:");
        characters.forEach(c -> System.out.println(c));

        int sumAge = characters
                .stream()
                .parallel()
                .mapToInt(FuturamaCharacter::getAge)
                .sum();
        System.out.println("\nSum of ages: " + sumAge);

        int sumAgeReduce = characters
                .stream()
                .parallel()
                .map(FuturamaCharacter::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println("\nSum of ages with reduce: " + sumAgeReduce);
    }
}
