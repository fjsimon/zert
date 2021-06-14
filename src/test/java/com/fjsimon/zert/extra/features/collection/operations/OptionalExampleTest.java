package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import com.fjsimon.zert.extra.features.common.Species;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalExampleTest {

    private static List<Optional<FuturamaCharacter>> characters = Arrays.asList(
            createOptional("Bender", "Rodriguez", Species.ROBOT),
            createOptional("Philip", "Fry", Species.HUMAN),
            createOptional("Turanga", "Leela", Species.MUTANT),
            createOptional("John", "Zoidberg", null),
            Optional.empty());

    @Test
    public void optionalTest() {

        System.out.printf("%nCharacters: %n");
        characters.forEach(c -> System.out.printf("%s, %s %n", getCharacterFullName(c), getSpeciesName(c)));
    }

    public String getCharacterFullName(Optional<FuturamaCharacter> character) {
        return character
                .map(FuturamaCharacter::toString)
                .orElse("Empty FuturamaCharacter optional!");
    }

    public String getSpeciesName(Optional<FuturamaCharacter> character) {
        return character
                .flatMap(FuturamaCharacter::getSpeciesEnum)
                .map(Species::name)
                .orElse("Possible alien species!");
    }

    @Test
    public void optionalExampleTest(){

        System.out.printf("%nRobots: %n");
        characters.stream()
                .filter(new RobotSpeciesPredicate())
                .forEach(c -> System.out.printf("%s %n", getCharacterFullName(c)));
    }

    public static class RobotSpeciesPredicate implements Predicate<Optional<FuturamaCharacter>> {

        @Override
        public boolean test(Optional<FuturamaCharacter> character) {
            return character.isPresent()
                    && character.get().getSpeciesEnum().isPresent()
                    && Species.ROBOT.equals(character.get().getSpeciesEnum().get());
        }
    }

    public static Optional<FuturamaCharacter> createOptional(String firstName, String lastName, Species species) {
        return Optional.of(new FuturamaCharacter(firstName, lastName, Optional.ofNullable(species)));
    }
}