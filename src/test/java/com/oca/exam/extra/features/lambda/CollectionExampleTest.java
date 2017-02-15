package com.oca.exam.extra.features.lambda;


import com.oca.exam.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CollectionExampleTest {

    @Test
    public void collection(){

        CollectionExample ex = new CollectionExample();
        List<FuturamaCharacter> characters = ex.getFuturamaCharacters();
        assertThat(characters.size(), is(4));

        System.out.println("\nCharacters by species: ");
        ex.getMap(characters).forEach((k, v) -> System.out.println(k + ": " + v));
        assertThat(ex.getMap(characters).size(), is(3));

        assertThat(ex.removeHumanCharacter(characters).size(), is(2));

        assertThat(ex.getIntegerList().size(), is(7));
        assertThat(ex.getIntegerList().contains(0), is(true));

    }
}