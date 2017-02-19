package com.oca.exam.extra.features.functional.interfaces;

import com.oca.exam.extra.features.common.FuturamaCharacter;
import java.util.function.Predicate;

public class MutantSpeciesPredicate implements Predicate<FuturamaCharacter> {

    @Override
    public boolean test(FuturamaCharacter character) {
        return character.getSpecies().equals("mutant");
    }
}
