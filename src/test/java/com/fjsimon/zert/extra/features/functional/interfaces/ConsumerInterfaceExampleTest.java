package com.fjsimon.zert.extra.features.functional.interfaces;

import com.fjsimon.zert.common.FuturamaCharacter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceExampleTest {

    private static final List<FuturamaCharacter> characters = Arrays.asList(
            new FuturamaCharacter("Bender", "Rodriguez"),
            new FuturamaCharacter("Philip", "Fry"),
            new FuturamaCharacter("Turanga", "Leela"));

    public Consumer<FuturamaCharacter> getFullnameConsumer() {

        Consumer<FuturamaCharacter> fullNameConsumer = c -> System.out.println(c.getFirstName() + " " + c.getLastName());
        return fullNameConsumer;
    }

    @Test
    public void futuramaCharactersTest() {


        System.out.println("\nFull names:");
        characters.forEach(getFullnameConsumer());

        System.out.println("\nInverted full names:");
        characters.forEach(new InvertedFullNameConsumer());

        System.out.println("\nFull names after introducing the side effect:");
        characters.forEach(getFullnameConsumer());

    }
}