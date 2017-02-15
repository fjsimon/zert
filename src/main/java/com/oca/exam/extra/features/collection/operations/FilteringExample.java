package com.oca.exam.extra.features.collection.operations;

import com.oca.exam.extra.features.common.FuturamaCharacter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class FilteringExample {

    public List<FuturamaCharacter> getFuturamaCharacters() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", "robot"),
                new FuturamaCharacter("Philip", "Fry", "human"),
                new FuturamaCharacter("Turanga", "Leela", "mutant"),
                new FuturamaCharacter("John", "Simon", "robot"));

        System.out.println("Futurama characters:");
        characters.forEach(System.out::println); // c -> System.out.println(c)
        return characters;
    }

    public List<FuturamaCharacter> getFuturamaCharactersBySpecies(List<FuturamaCharacter> characters, String specie) {

        return characters.stream()
                .filter(c -> c.getSpecies().equals(specie))
                .collect(toList());
    }

    public List<FuturamaCharacter> getMutantFuturamaCharacters(List<FuturamaCharacter> characters) {

        return  characters.stream()
                .peek(c -> System.out.println("Filtered value: " + c))
                .filter(new MutantSpeciesPredicate())
                .collect(toList());
    }

    private class MutantSpeciesPredicate implements Predicate<FuturamaCharacter> {

        @Override
        public boolean test(FuturamaCharacter character) {
            return "mutant".equals(character.getSpecies());
        }
    }

}
