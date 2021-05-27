package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class ForEachExample {

    public static void main(String... args) {

        BiFunction<String, String, FuturamaCharacter> bf = FuturamaCharacter::new;

        List<FuturamaCharacter> characters = Arrays.asList(
                bf.apply("Philip", "Fry"),
                bf.apply("Bender", "Rodriguez"),
                bf.apply("Turanga", "Leela"));

        // Java 7
        System.out.println("\nJava 7\n");
        for (FuturamaCharacter character : characters) {
            character.print();
        }

        // Java 8
        System.out.println("\nJava 8\n");
        characters.forEach(FuturamaCharacter::print);
        System.out.println();
        characters.forEach(c -> System.out.println(c.getFirstName().toUpperCase() + " " + c.getLastName().toUpperCase()));
    }
}
