package com.fjsimon.zert.extra.features.lambda;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import com.fjsimon.zert.extra.features.common.Species;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionExample {

    public List<FuturamaCharacter> getFuturamaCharacters() {

        List<FuturamaCharacter> characters = new LinkedList<>(
                Arrays.asList(
                        new FuturamaCharacter("Bender", "Rodriguez", 5, Optional.of(Species.ROBOT)),
                        new FuturamaCharacter("Philip", "Fry", 126, Optional.of(Species.HUMAN)),
                        new FuturamaCharacter("Turanga", "Leela", 22, Optional.of(Species.MUTANT)),
                        new FuturamaCharacter("Hubert", "Farnsworth", 161, Optional.of(Species.HUMAN))
                )
        );

        System.out.println("Futurama characters:");
        characters.forEach(System.out::println);
        return characters;
    }

    public Map<Species, List<FuturamaCharacter>> getMap(List<FuturamaCharacter> characters) {

        // Map.forEach
        Map<Species, List<FuturamaCharacter>> speciesToFuturamaCharactersMap = characters
                .stream()
                .collect(Collectors.groupingBy(c -> c.getSpeciesEnum().get()));

        return speciesToFuturamaCharactersMap;
    }

    public List<FuturamaCharacter> removeHumanCharacter(List<FuturamaCharacter> characters) {

        // List.removeIf
        characters.removeIf(c -> !c.getSpecies().equals(Species.HUMAN.toString()));
        return characters;
    }

    public List<Integer> getIntegerList() {

        // List.replaceAll
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        numbers.replaceAll(x -> x % 2 == 0 ? x : 0);
        return numbers;
    }

}
