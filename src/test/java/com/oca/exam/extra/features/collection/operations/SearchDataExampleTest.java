package com.oca.exam.extra.features.collection.operations;


import com.oca.exam.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.util.List;
import java.util.OptionalInt;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchDataExampleTest {

    @Test
    public void searchDataExampleTest(){

        SearchDataExample ex = new SearchDataExample();
        List<FuturamaCharacter> characters = ex.getFuturamaCharacters();

        System.out.printf("%nFuturama characters:%n");
        characters.forEach(System.out::println);

        System.out.printf("%nAll hashcodes:%n");
        characters.stream()
                .mapToInt(FuturamaCharacter::hashCode)
                .sorted()
                .forEach(System.out::println);

        assertThat("First negative hashcode", ex.getFirstNegativeHashcode(characters).getAsInt(), is(-2006610387));
        assertThat("Characters contain a robot", ex.hasContentOf(characters, "robot"), is(true));
        assertThat("Characters do not contain an alien", ex.hasNonContentOf(characters, "alien"), is(true));
        assertThat("Characters contain only humans", ex.containsOnlyHuman(characters), is(false));


        OptionalInt anyHashcode = characters
                .stream()
                .mapToInt(FuturamaCharacter::hashCode)
                .filter(hc -> hc != ex.getFirstNegativeHashcode(characters).getAsInt())
                .findAny();
        System.out.println("Any hashcode except the first negative hashcode: "
                + (anyHashcode.isPresent() ? anyHashcode.getAsInt() : "Not found"));
    }
}