package com.fjsimon.zert.methods;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaticInnerClassTest {

    @Test
    public void staticInnerClassTest () {

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
