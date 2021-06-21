package com.fjsimon.zert.extra.features.functional.interfaces;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateInterfaceExampleTest {

    private static final List<FuturamaCharacter> characters = Arrays.asList(
            new FuturamaCharacter("Bender", "Rodriguez", "robot"),
            new FuturamaCharacter("Philip", "Fry", "human"),
            new FuturamaCharacter("Turanga", "Leela", "mutant"),
            new FuturamaCharacter("John", "Zoidberg", "alien"));

    @Test
    public void predicateInterfaceTest() {

        characters.stream().forEach(c -> System.out.printf("Evaluating character's species[%s] %n", c.getSpecies()));

        System.out.println("\nRobots:");
        printCharactersBySpecies(characters, c -> c.getSpecies().equals("robot"));

        System.out.println("\nMutants:");
        printCharactersBySpecies(characters, new MutantSpeciesPredicate());

        System.out.println("\nAliens:");
        printCharactersBySpecies(characters, FuturamaCharacter::isAlienSpecies);

        System.out.println("\nHumans:");
        printCharactersBySpecies(
                characters,
                c -> c.getSpecies().equals("human"),
                c -> System.out.println(c.getFirstName() + " " + c.getLastName().toUpperCase()));
    }

    private static void printCharactersBySpecies(List<FuturamaCharacter> characters,
                                                Predicate<FuturamaCharacter> predicate) {
        characters.stream()
                .filter(predicate::test)
                .forEach(c -> System.out.println(c.getFirstName() + " " + c.getLastName()));
    }

    private static void printCharactersBySpecies(List<FuturamaCharacter> characters,
                                                Predicate<FuturamaCharacter> predicate,
                                                Consumer<FuturamaCharacter> consumer) {
        characters.stream()
                .filter(predicate::test)
                .forEach(consumer::accept);
    }
}
