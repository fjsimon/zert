package com.fjsimon.zert.extra.features.functional.interfaces;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import java.util.function.Predicate;

public class MutantSpeciesPredicate implements Predicate<FuturamaCharacter> {

    @Override
    public boolean test(FuturamaCharacter character) {
        return character.getSpecies().equals("mutant");
    }
}
