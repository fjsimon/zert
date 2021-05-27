package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExtractDataWithMapExample {

    public List<FuturamaCharacter> getFuturamaCharacters() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", "robot"),
                new FuturamaCharacter("Philip", "Fry", "human"),
                new FuturamaCharacter("Turanga", "Leela", "mutant"),
                new FuturamaCharacter("Zapp", "Brannigan", "human"));

        System.out.println("Futurama characters:");
        characters.forEach(System.out::println); // c -> System.out.println(c)
        return characters;
    }

    public Stream<String> getStream(List<FuturamaCharacter> characters) {

        Stream<String> speciesStream = characters.stream()
                .peek(c -> System.out.println("Filtered value: " + c))
                // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
                .map(FuturamaCharacter::getSpecies) // c -> c.getSpecies()
                .peek(s -> System.out.println("Mapped value: " + s.toUpperCase()))
                .distinct()
                .sorted();

        return speciesStream;
    }

    public IntStream getIntStream(List<FuturamaCharacter> characters) {

        IntStream hashcodeStream = characters.stream()
                // IntStream mapToInt(ToIntFunction<? super T> mapper);
                .mapToInt(FuturamaCharacter::hashCode) // c -> c.hashCode()
                .peek(hc -> System.out.println("Mapped value: " + hc))
                .sorted();

        return hashcodeStream;
    }

}
