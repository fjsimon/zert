package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class SearchDataExample {

    public List<FuturamaCharacter> getFuturamaCharacters() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", "robot"),
                new FuturamaCharacter("Philip", "Fry", "human"),
                new FuturamaCharacter("Turanga", "Leela", "mutant"),
                new FuturamaCharacter("Zapp", "Brannigan", "human"));

        return characters;
    }

    public OptionalInt getFirstNegativeHashcode(List<FuturamaCharacter> characters) {
        OptionalInt firstNegativeHashcode = characters
                .stream()
                .mapToInt(FuturamaCharacter::hashCode)
                .sorted()
                .findFirst();
        return firstNegativeHashcode;
    }

    public boolean hasContentOf(List<FuturamaCharacter> characters, String type) {

        boolean contains = characters
                .stream()
                .anyMatch(c -> c.getSpecies().equals(type));
        return contains;
    }

    public boolean hasNonContentOf(List<FuturamaCharacter> characters, String type) {

        boolean contains = characters
                .stream()
                .noneMatch(c -> c.getSpecies().equals(type));
        return contains;
    }

    public boolean containsOnlyHuman(List<FuturamaCharacter> characters) {

        boolean containsOnlyHumans = characters
                .stream()
                .allMatch(FuturamaCharacter::isHumanSpecies);
        return containsOnlyHumans;
    }
}
