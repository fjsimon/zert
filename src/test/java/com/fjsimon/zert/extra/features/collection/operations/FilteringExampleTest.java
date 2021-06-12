package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class FilteringExampleTest {

    private final List<FuturamaCharacter> characters = Arrays.asList(
            new FuturamaCharacter("Bender", "Rodriguez", "robot"),
            new FuturamaCharacter("Philip", "Fry", "human"),
            new FuturamaCharacter("Turanga", "Leela", "mutant"),
            new FuturamaCharacter("John", "Simon", "robot"));

    @Test
    public void getFuturamaCharactersBySpecies() {

        assertThat(characters.stream()
                .filter(c -> c.getSpecies().equals("robot"))
                .collect(toList()).size(), is(2));
        assertThat(characters.stream()
                .filter(c -> c.getSpecies().equals("human"))
                .collect(toList()).size(), is(1));
        assertThat(characters.stream()
                .filter(c -> c.getSpecies().equals("mutant"))
                .collect(toList()).size(), is(1));
    }

    @Test
    public void getMutantFuturamaCharacters() {

        assertThat(characters.stream()
                .peek(c -> System.out.println("Filtered value: " + c))
                .filter(new MutantSpeciesPredicate())
                .collect(toList()).size(), is(1));

    }

    private class MutantSpeciesPredicate implements Predicate<FuturamaCharacter> {

        @Override
        public boolean test(FuturamaCharacter character) {
            return "mutant".equals(character.getSpecies());
        }
    }
}