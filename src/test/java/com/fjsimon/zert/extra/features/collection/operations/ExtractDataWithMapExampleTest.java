package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExtractDataWithMapExampleTest {

    private final List<FuturamaCharacter> characters = Arrays.asList(
            new FuturamaCharacter("Bender", "Rodriguez", "robot"),
            new FuturamaCharacter("Philip", "Fry", "human"),
            new FuturamaCharacter("Turanga", "Leela", "mutant"),
            new FuturamaCharacter("Zapp", "Brannigan", "human"));

    @Test
    public void getFuturamaCharacters() {

        System.out.println("Futurama characters:");
        characters.forEach(System.out::println); // c -> System.out.println(c)
        assertThat(characters.size(), is(4));
    }

    @Test
    public void getStream() {

        Stream<String> speciesStream = characters.stream()
                .peek(c -> System.out.println("Filtered value: " + c))
                // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
                .map(FuturamaCharacter::getSpecies) // c -> c.getSpecies()
                .peek(s -> System.out.println("Mapped value: " + s.toUpperCase()))
                .distinct()
                .sorted();

        assertThat(speciesStream.count(), is(3L));

//        speciesStream.forEach(System.out::println);
//        java.lang.IllegalStateException: stream has already been operated upon or closed
    }

    @Test
    public void getIntStream() {

        IntStream hashcodeStream = characters.stream()
                // IntStream mapToInt(ToIntFunction<? super T> mapper);
                .mapToInt(FuturamaCharacter::hashCode) // c -> c.hashCode()
                .peek(hc -> System.out.println("Mapped value: " + hc))
                .sorted();

        assertThat(hashcodeStream.count(), is(4L));

//        hashcodeStream.forEach(System.out::println);
//        java.lang.IllegalStateException: stream has already been operated upon or closed
    }
}