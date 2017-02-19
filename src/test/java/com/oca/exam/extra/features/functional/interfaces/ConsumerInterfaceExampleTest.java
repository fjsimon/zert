package com.oca.exam.extra.features.functional.interfaces;


import com.oca.exam.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class ConsumerInterfaceExampleTest {

    @Test
    public void futuramaCharactersTest() {

        ConsumerInterfaceExample ex = new ConsumerInterfaceExample();
        List<FuturamaCharacter> characters = ex.getFuturamaCharacters();
        assertThat(characters, is(not(nullValue())));

        System.out.println("\nFull names:");
        characters.forEach(ex.getFullnameConsumer());

        System.out.println("\nInverted full names:");
        characters.forEach(new InvertedFullNameConsumer());

        System.out.println("\nFull names after introducing the side effect:");
        characters.forEach(ex.getFullnameConsumer());

    }
}