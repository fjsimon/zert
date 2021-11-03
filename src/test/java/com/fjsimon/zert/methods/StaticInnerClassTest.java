package com.fjsimon.zert.methods;

import com.fjsimon.zert.BaseTest;
import com.fjsimon.zert.common.FuturamaCharacter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaticInnerClassTest extends BaseTest {

    @Test
    public void staticInnerClassTest () {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez"),
                new FuturamaCharacter("Turanga", "Leela"),
                new FuturamaCharacter("Philip", "Fry"));

        System.out.println("Before sorting: " + characters);

        FuturamaCharacter.FirstNameAscComparator
                comparatorAsc =
                new FuturamaCharacter.FirstNameAscComparator();
        Collections.sort(characters, comparatorAsc);

        System.out.println("After sorting (asc): " + characters);

        FuturamaCharacter.FirstNameDescComparator
                comparatorDesc =
                new FuturamaCharacter.FirstNameDescComparator();
        Collections.sort(characters, comparatorDesc);

        System.out.println("After sorting (desc): " + characters);
    }
}
