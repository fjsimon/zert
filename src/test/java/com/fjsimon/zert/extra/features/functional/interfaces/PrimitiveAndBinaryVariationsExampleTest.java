package com.fjsimon.zert.extra.features.functional.interfaces;

import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

public class PrimitiveAndBinaryVariationsExampleTest {


    @Test
    public void biConsumerTest() {

        BiFunction<String, String, FuturamaCharacter> bf = (firstName, lastName) -> new FuturamaCharacter(firstName, lastName);

        List<FuturamaCharacter> characters = Arrays.asList(
                bf.apply("Bender", "Rodriguez"),
                bf.apply("Philip", "Fry"),
                bf.apply("Turanga", "Leela"));

        BiConsumer<String, String> biConsumer = (firstName, lastName) -> System.out.println(lastName.toUpperCase() + ", " + firstName);

        for (FuturamaCharacter c : characters) {
            biConsumer.accept(c.getFirstName(), c.getLastName());
        }

    }

    @Test
    public void intConsumerTest() {

        IntBinaryOperator intBinaryOperator = (s1, s2) -> s1 * s2;
        int side1 = 3, side2 = 8;
        IntConsumer intConsumer = (area)
                -> System.out.println("Area for rectangle with sides[" + side1 + ", " + side2 + "] is " + area);

        intConsumer.accept(intBinaryOperator.applyAsInt(side1, side2));
    }
}