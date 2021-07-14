package com.fjsimon.zert.extra.features.collection.operations;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;
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
    public void getCountStringStream() {

        String[] words = {"sporadic", "perjury", "confounded", "skimming", "incumbent", "jailer"};

        Stream<String> stream = Stream.of(words);
        System.out.println("Words in upper case: ");
        stream.map(String::toUpperCase).forEach(System.out::println);

        long count = Arrays.stream(words).count();
        System.out.printf("%nWords count: %d%n", count);
        assertThat(count, is(6L));
    }

    @Test
    public void streamFlatMap() {

        List<String> phrases = Arrays.asList(
                "sporadic perjury",
                "confounded skimming",
                "incumbent jailer",
                "confounded jailer");

        List<String> uniqueWords = phrases
                .stream()
                .flatMap(phrase -> Stream.of(phrase.split(" +")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Unique words: " + uniqueWords);

        assertThat(uniqueWords.size(), is(6));
    }

    @Test
    public void lengthOfWordsMapTest() {

        Map<Integer, String> lengthToWordsMap = new HashMap<>();
        Consumer<String> action = w -> {
            BiFunction<String, String, String> remappingFunction = (value, newValue) -> value + ", " + newValue;
            lengthToWordsMap.merge(w.length(), w, remappingFunction);
        };

        Arrays.asList("confounded", "incumbent", "jailer", "perjury", "skimming", "sporadic").forEach(action);

        lengthToWordsMap.forEach((key, value) -> System.out.printf("%nWords with length %d: %s", key, value));

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

    @Test
    public void getSumStream() {

        int startInclusive = 1;
        int endExclusive = 100_000;
        long sum = IntStream.range(startInclusive, endExclusive).sum();
        System.out.printf("%nSum[%d, %d]: %d", startInclusive, endExclusive, sum);

        assertThat(sum, is(704982704L));
    }
}