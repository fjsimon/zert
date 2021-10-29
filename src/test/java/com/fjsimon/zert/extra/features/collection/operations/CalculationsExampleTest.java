package com.fjsimon.zert.extra.features.collection.operations;


import com.fjsimon.zert.BaseTest;
import com.fjsimon.zert.common.FuturamaCharacter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculationsExampleTest extends BaseTest {

    @Test
    public void getFuturamaCharacters() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", 5),
                new FuturamaCharacter("Philip", "Fry", 126),
                new FuturamaCharacter("Turanga", "Leela", 22));

        System.out.println("Futurama characters:");
        characters.forEach(System.out::println); // c -> System.out.println(c)
    }

    @Test
    public void forEachTest() {

        BiFunction<String, String, FuturamaCharacter> bf = FuturamaCharacter::new;

        List<FuturamaCharacter> characters = Arrays.asList(
                bf.apply("Philip", "Fry"),
                bf.apply("Bender", "Rodriguez"),
                bf.apply("Turanga", "Leela"));

        // Java 7
        System.out.println("\nJava 7\n");
        for (FuturamaCharacter character : characters) {
            character.print();
        }

        // Java 8
        System.out.println("\nJava 8\n");
        characters.forEach(FuturamaCharacter::print);

        System.out.println("\nJava 8 uppercase\n");
        characters.forEach(c -> System.out.println(c.getFirstName().toUpperCase() + " " + c.getLastName().toUpperCase()));
    }

    @Test
    public void getCount() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", 5),
                new FuturamaCharacter("Philip", "Fry", 126),
                new FuturamaCharacter("Turanga", "Leela", 22));

        long count = characters
                .stream()
                .count();
        System.out.println("\nCharacters count: " + count);

        assertThat(count, is(3L));
    }

    @Test
    public void getMinAge() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", 5),
                new FuturamaCharacter("Philip", "Fry", 126),
                new FuturamaCharacter("Turanga", "Leela", 22));

        OptionalInt minAge = characters
                .stream()
                .mapToInt(FuturamaCharacter::getAge) // c -> c.getAge()
                .min();
        System.out.println("Characters min age: "
                + (minAge.isPresent() ? minAge.getAsInt() : "Not available"));

        assertThat(minAge.getAsInt(), is(5));
    }

    @Test
    public void getMaxAge() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", 5),
                new FuturamaCharacter("Philip", "Fry", 126),
                new FuturamaCharacter("Turanga", "Leela", 22));

        OptionalInt maxAge = characters
                .stream()
                .mapToInt(FuturamaCharacter::getAge)
                .max();
        System.out.println("Characters max age: "
                + (maxAge.isPresent() ? maxAge.getAsInt() : "Not available"));

        assertThat(maxAge.getAsInt(), is(126));
    }

    @Test
    public void getAverageAge() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", 5),
                new FuturamaCharacter("Philip", "Fry", 126),
                new FuturamaCharacter("Turanga", "Leela", 22));

        OptionalDouble averageAge = characters
                .stream()
                .mapToDouble(FuturamaCharacter::getAge)
                .average();
        System.out.println("Characters average age: "
                + (averageAge.isPresent() ? averageAge.getAsDouble() : "Not available"));

        assertThat(averageAge.getAsDouble(), is(51.0));
    }

    @Test
    public void getTotal() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", 5),
                new FuturamaCharacter("Philip", "Fry", 126),
                new FuturamaCharacter("Turanga", "Leela", 22));

        int sumAge = characters
                .stream()
                .mapToInt(FuturamaCharacter::getAge)
                .sum();
        System.out.println("Characters sum of ages: " + sumAge);

        assertThat(sumAge, is(153));
    }


}