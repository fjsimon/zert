package com.fjsimon.zert.extra.features.lambda;


import com.fjsimon.zert.common.FuturamaCharacter;
import com.fjsimon.zert.common.Species;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CollectionExampleTest {

    private static final List<FuturamaCharacter> characters = new LinkedList<>(
            Arrays.asList(
                    new FuturamaCharacter("Bender", "Rodriguez", 5, Optional.of(Species.ROBOT)),
                    new FuturamaCharacter("Philip", "Fry", 126, Optional.of(Species.HUMAN)),
                    new FuturamaCharacter("Turanga", "Leela", 22, Optional.of(Species.MUTANT)),
                    new FuturamaCharacter("Hubert", "Farnsworth", 161, Optional.of(Species.HUMAN))
            )
    );

    @Test
    public void collection(){

        assertThat(characters.size(), is(4));

        System.out.println("\nCharacters by species: ");
        getMapGroupBySpecies(characters).forEach((k, v) -> System.out.println(k + ": " + v));
        assertThat(getMapGroupBySpecies(characters).size(), is(3));
        assertThat(removeHumanCharacter(characters).size(), is(2));
    }

    private Map<Species, List<FuturamaCharacter>> getMapGroupBySpecies(List<FuturamaCharacter> characters) {

        return characters
                .stream()
                .collect(Collectors.groupingBy(c -> c.getSpeciesEnum().get()));
    }

    private List<FuturamaCharacter> removeHumanCharacter(List<FuturamaCharacter> characters) {

        characters.removeIf(c -> !c.getSpecies().equals(Species.HUMAN.toString()));
        return characters;
    }

}