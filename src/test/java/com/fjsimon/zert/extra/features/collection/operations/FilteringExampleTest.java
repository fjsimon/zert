package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FilteringExampleTest {

    @Test
    public void filteringTest(){

        FilteringExample ex = new FilteringExample();
        List<FuturamaCharacter> characters = ex.getFuturamaCharacters();
        assertThat(characters.size(), is(4));
        assertThat(ex.getFuturamaCharactersBySpecies(characters, "robot").size(), is(2));
        assertThat(ex.getFuturamaCharactersBySpecies(characters, "human").size(), is(1));
        assertThat(ex.getFuturamaCharactersBySpecies(characters, "mutant").size(), is(1));

        assertThat(ex.getMutantFuturamaCharacters(characters).size(), is(1));

    }
}