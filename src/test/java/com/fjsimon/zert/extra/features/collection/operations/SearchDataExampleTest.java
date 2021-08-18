package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.common.FuturamaCharacter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class SearchDataExampleTest {

    private static final List<FuturamaCharacter> characters = Arrays.asList(
            new FuturamaCharacter("Bender", "Rodriguez", "robot"),
            new FuturamaCharacter("Philip", "Fry", "human"),
            new FuturamaCharacter("Turanga", "Leela", "mutant"),
            new FuturamaCharacter("Zapp", "Brannigan", "human"));

    @Test
    public void getFirstNegativeHashcodeTest() {

        OptionalInt firstNegativeHashcode = characters
                .stream()
                .mapToInt(FuturamaCharacter::hashCode)
                .sorted()
                .findFirst();

        assertThat("First negative hashcode", firstNegativeHashcode.getAsInt(), is(-2006610387));
    }

    @Test
    public void anyHashcodeExceptFirstTest() {

        OptionalInt firstNegativeHashcode = characters
                .stream()
                .mapToInt(FuturamaCharacter::hashCode)
                .sorted()
                .findFirst();

        OptionalInt anyHashcode = characters
                .stream()
                .mapToInt(FuturamaCharacter::hashCode)
                .filter(hc -> hc != firstNegativeHashcode.getAsInt())
                .findAny();

        System.out.println("Any hashcode except the first negative hashcode: "
                + (anyHashcode.isPresent() ? anyHashcode.getAsInt() : "Not found"));

        assertThat("First negative hashcode", anyHashcode.getAsInt(), is(-570677118));
    }

    @Test
    public void hasContentOfTest() {

        boolean containsRobot = characters
                .stream()
                .anyMatch(c -> c.getSpecies().equals("robot"));

        assertThat("Characters contain a robot", containsRobot, is(true));
    }

    @Test
    public void hasNonContentOfTest() {

        boolean containsAlien = characters
                .stream()
                .noneMatch(c -> c.getSpecies().equals("alien"));

        assertThat("Characters do not contain an alien", containsAlien, is(true));
    }

    @Test
    public void containsOnlyHumanTest() {

        boolean containsOnlyHumans = characters
                .stream()
                .allMatch(FuturamaCharacter::isHumanSpecies);

        assertThat("Characters contain only humans", containsOnlyHumans, is(false));
    }

    @Test
    public void searchDataExampleTest(){

        System.out.printf("%nFuturama characters:%n");
        characters.forEach(System.out::println);

        System.out.printf("%nAll hashcodes:%n");
        characters.stream()
                .mapToInt(FuturamaCharacter::hashCode)
                .sorted()
                .forEach(System.out::println);
    }
}