package com.oca.exam.extra.features.method.enhancements;

import com.oca.exam.extra.features.common.FuturamaCharacter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaticInnerClassExample {

    public static void main(String... args) {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez"),
                new FuturamaCharacter("Turanga", "Leela"),
                new FuturamaCharacter("Philip", "Fry"));

        System.out.println("Before sorting: " + characters);

        FuturamaCharacter.FirstNameAscComparator
                comparator =
                new FuturamaCharacter.FirstNameAscComparator();
        Collections.sort(characters, comparator);
        System.out.println("After sorting: " + characters);
    }
}
