package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class OptionalExampleTest {

    @Test
    public void optionalExampleTest(){

        OptionalExample ex = new OptionalExample();
        List<Optional<FuturamaCharacter>> characters = ex.getFuturamaCharacters();

        characters.forEach(c -> System.out.printf("%s, %s %n", ex.getCharacterFullName(c), ex.getSpeciesName(c)));

        System.out.printf("%nRobots: %n");
        characters.stream()
                .filter(new OptionalExample.RobotSpeciesPredicate())
                .forEach(c -> System.out.printf("%s %n", ex.getCharacterFullName(c)));
    }
}