package com.oca.exam.extra.features.collection.operations;


import com.oca.exam.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class CalculationsExampleTest {

    @Test
    public void futuramaCharactersTest(){

        CalculationsExample ex = new CalculationsExample();
        List<FuturamaCharacter> characters = ex.getFuturamaCharacters();
        assertThat(characters, is(not(nullValue())));

        assertThat(ex.getCount(characters), is(3L));
        assertThat(ex.getMinAge(characters).getAsInt(), is(5));
        assertThat(ex.getMaxAge(characters).getAsInt(), is(126));
        assertThat(ex.getAverageAge(characters).getAsDouble(), is(51.0));
        assertThat(ex.getTotal(characters), is(153));

    }

}