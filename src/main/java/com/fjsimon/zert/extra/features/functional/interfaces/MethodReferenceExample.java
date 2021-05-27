package com.fjsimon.zert.extra.features.functional.interfaces;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static java.util.Comparator.comparing;

public class MethodReferenceExample {

    public static void main(String... args) {

        BiFunction<String, String, FuturamaCharacter> biFunctionLambda =
                (firstName, lastName) -> new FuturamaCharacter(firstName, lastName);

        BiFunction<String, String, FuturamaCharacter> biFunctionMethodReference =
                FuturamaCharacter::new; // method reference

        List<FuturamaCharacter> characters = Arrays.asList(
                biFunctionLambda.apply("Philip", "Fry"),
                biFunctionMethodReference.apply("Bender", "Rodriguez"),
                biFunctionMethodReference.apply("Turanga", "Leela"));

        System.out.println("\nBefore sorting:");
        characters.forEach(c -> c.print());

        System.out.println("\nAfter sorting by last name(ASC):");
        characters.sort((FuturamaCharacter c1, FuturamaCharacter c2)
                -> c1.getLastName().compareTo(c2.getLastName()));

        characters.forEach(FuturamaCharacter::print); // method reference

        System.out.println("\nAfter sorting by first name(ASC):");
        characters.sort(comparing(FuturamaCharacter::getFirstName)); // method reference

        characters.forEach(FuturamaCharacter::print); // method reference
    }
}
