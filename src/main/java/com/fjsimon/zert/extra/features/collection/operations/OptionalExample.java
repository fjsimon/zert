package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import com.fjsimon.zert.extra.features.common.Species;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalExample {

    public List<Optional<FuturamaCharacter>> getFuturamaCharacters() {

        List<Optional<FuturamaCharacter>> characters = Arrays.asList(
                createOptional("Bender", "Rodriguez", Species.ROBOT),
                createOptional("Philip", "Fry", Species.HUMAN),
                createOptional("Turanga", "Leela", Species.MUTANT),
                createOptional("John", "Zoidberg", null),
                Optional.empty());


        return characters;
    }

    public String getCharacterFullName(Optional<FuturamaCharacter> c) {
        return c.map(FuturamaCharacter::toString)
                .orElse("Empty FuturamaCharacter optional!");
    }

    public String getSpeciesName(Optional<FuturamaCharacter> character) {

        return character.flatMap(FuturamaCharacter::getSpeciesEnum)
                .map(Species::name)
                .orElse("Possible alien species!");
    }

    public Optional<FuturamaCharacter> createOptional(String firstName, String lastName, Species species) {
        return Optional.of(new FuturamaCharacter(firstName, lastName, Optional.ofNullable(species)));
    }

    public static class RobotSpeciesPredicate implements Predicate<Optional<FuturamaCharacter>> {

        @Override
        public boolean test(Optional<FuturamaCharacter> character) {
            return character.isPresent()
                    && character.get().getSpeciesEnum().isPresent()
                    && Species.ROBOT.equals(character.get().getSpeciesEnum().get());
        }
    }
}
