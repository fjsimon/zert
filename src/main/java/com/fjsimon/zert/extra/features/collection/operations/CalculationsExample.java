package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CalculationsExample {

    public List<FuturamaCharacter> getFuturamaCharacters() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", 5),
                new FuturamaCharacter("Philip", "Fry", 126),
                new FuturamaCharacter("Turanga", "Leela", 22));

        System.out.println("Futurama characters:");
        characters.forEach(System.out::println); // c -> System.out.println(c)
        return characters;
    }

    public long getCount(List<FuturamaCharacter> characters) {

        long count = characters
                .stream()
                .count();
        System.out.println("\nCharacters count: " + count);
        return count;
    }

    public OptionalInt getMinAge(List<FuturamaCharacter> characters) {

        OptionalInt minAge = characters
                .stream()
                .mapToInt(FuturamaCharacter::getAge) // c -> c.getAge()
                .min();
        System.out.println("Characters min age: "
                + (minAge.isPresent() ? minAge.getAsInt() : "Not available"));
        return minAge;
    }

    public OptionalInt getMaxAge(List<FuturamaCharacter> characters) {

        OptionalInt maxAge = characters
                .stream()
                .mapToInt(FuturamaCharacter::getAge)
                .max();
        System.out.println("Characters max age: "
                + (maxAge.isPresent() ? maxAge.getAsInt() : "Not available"));
        return maxAge;
    }

    public OptionalDouble getAverageAge(List<FuturamaCharacter> characters) {

        OptionalDouble averageAge = characters
                .stream()
                .mapToDouble(FuturamaCharacter::getAge)
                .average();
        System.out.println("Characters average age: "
                + (averageAge.isPresent() ? averageAge.getAsDouble() : "Not available"));
        return averageAge;
    }

    public int getTotal(List<FuturamaCharacter> characters) {

        int sumAge = characters
                .stream()
                .mapToInt(FuturamaCharacter::getAge)
                .sum();
        System.out.println("Characters sum of ages: " + sumAge);
        return sumAge;
    }
}
