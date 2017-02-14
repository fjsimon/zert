package com.oca.exam.extra.features.collection.operations;

import com.oca.exam.extra.features.common.FuturamaCharacter;

import org.junit.Test;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class ExtractDataWithMapExampleTest {

    @Test
    public void extractDataWithMapExampleTest(){

        ExtractDataWithMapExample ex = new ExtractDataWithMapExample();
        List<FuturamaCharacter> characters = ex.getFuturamaCharacters();
        assertThat(characters.size(), is(4));

        assertThat(ex.getStream(characters).count(), is(3L));
        System.out.println("\nDistinct Futurama character species:");
        ex.getStream(characters).forEach(System.out::println);

        assertThat(ex.getIntStream(characters).count(), is(4L));
        System.out.println("\nHashcodes:");
        ex.getIntStream(characters).forEach(System.out::println);
    }
}