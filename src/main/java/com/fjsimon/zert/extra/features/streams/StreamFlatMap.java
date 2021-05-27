package com.fjsimon.zert.extra.features.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFlatMap {

    public static void main(String... args) {


        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        Stream<String[]> temp = Arrays.stream(data);
        //filter a stream of string[], and return a string[]?
        Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));
        stream.forEach(System.out::println);


        temp = Arrays.stream(data);
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
        Stream<String> flatStream = stringStream.filter(x -> "a".equals(x.toString()));

        flatStream.forEach(System.out::println);

    }

}


