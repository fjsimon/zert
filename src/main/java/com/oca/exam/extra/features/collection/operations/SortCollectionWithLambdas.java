package com.oca.exam.extra.features.collection.operations;

import com.oca.exam.extra.features.common.FuturamaCharacter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class SortCollectionWithLambdas {

    public static void main(String... args) {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", 5),
                new FuturamaCharacter("Cubert", "Farnsworth", 12),
                new FuturamaCharacter("Turanga", "Leela", 22),
                new FuturamaCharacter("Hubert", "Farnsworth", 161));

        System.out.println("Futurama characters:");
        characters.forEach(System.out::println);

        // Java 7
        System.out.println("\nSorted by last name ASC (Java 7):");
        Comparator<FuturamaCharacter> lastNameAscComparator = new Comparator<FuturamaCharacter>() {
            @Override
            public int compare(FuturamaCharacter c1, FuturamaCharacter c2) {
                return c1.getLastName().compareTo(c2.getLastName());
            }
        };
        Collections.sort(characters, lastNameAscComparator);
        characters.forEach(System.out::println);

        // Java 8
        System.out.println("\nSorted by first name ASC (Java 8):");
        Comparator<FuturamaCharacter> firstNameAscComparator = (c1, c2) ->
                c1.getFirstName().compareTo(c2.getFirstName());
        Collections.sort(characters, firstNameAscComparator);
        characters.forEach(System.out::println);

        System.out.println("\nSorted by age ASC (Java 8):");
        Collections.sort(characters, comparing(FuturamaCharacter::getAge));
        characters.forEach(System.out::println);

        System.out.println("\nSorted by last name ASC (Java 8):");
        characters.sort((c1, c2) -> c1.getLastName().compareTo(c2.getLastName()));
        characters.forEach(System.out::println);

        System.out.println("\nAgain sorted by first name ASC (Java 8):");
        characters.sort(comparing(FuturamaCharacter::getFirstName));
        characters.forEach(System.out::println);

        System.out.println("\nSorted by last name ASC and first name DESC (Java 8):");
        Comparator<FuturamaCharacter> lastNameAscAndFirstNameDescComparator =
                comparing(FuturamaCharacter::getLastName)
                        // DESC
                        .thenComparing((c1, c2) -> c2.getFirstName().compareTo(c1.getFirstName()));
        characters.sort(lastNameAscAndFirstNameDescComparator);
        characters.forEach(c -> System.out.println(c.getLastName() + ", " + c.getFirstName()));
    }
}
