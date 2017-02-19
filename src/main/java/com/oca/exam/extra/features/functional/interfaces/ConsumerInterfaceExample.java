package com.oca.exam.extra.features.functional.interfaces;


import com.oca.exam.extra.features.common.FuturamaCharacter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceExample {

    public List<FuturamaCharacter> getFuturamaCharacters() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez"),
                new FuturamaCharacter("Philip", "Fry"),
                new FuturamaCharacter("Turanga", "Leela"));

        System.out.println("Futurama characters:");
        characters.forEach(System.out::println); // c -> System.out.println(c)
        return characters;
    }

    public Consumer<FuturamaCharacter> getFullnameConsumer() {

        Consumer<FuturamaCharacter> fullNameConsumer =
                c -> System.out.println(c.getFirstName() + " " + c.getLastName());

        return fullNameConsumer;
    }


}
