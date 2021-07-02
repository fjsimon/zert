package com.fjsimon.zert.extra.features.functional.interfaces;


import com.fjsimon.zert.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UnaryAndBinaryOperatorInterfacesExampleTest {

    private static final List<FuturamaCharacter> characters = Arrays.asList(
            new FuturamaCharacter("Bender", "Rodriguez"),
            new FuturamaCharacter("Philip", "Fry"),
            new FuturamaCharacter("Amy", "Wong")
    );

    @Test
    public void getUnaryOperatorTest() {

        UnaryOperator<String> toUpperCaseUnaryOperator = getUnaryOperator();

        for (FuturamaCharacter c : characters) {
            System.out.println("Full name: " + c.getFirstName() + " "
                    + toUpperCaseUnaryOperator.apply(c.getLastName()));
        }

        // the same, one-liner
        characters.forEach(c -> System.out.println("Full name: " + c.getFirstName() + " " +
                toUpperCaseUnaryOperator.apply(c.getLastName())));
    }

    @Test
    public void getBinaryOperatorTest() {
        BinaryOperator<BigDecimal> sumBinaryOperator = getBinaryOperator();

        BigDecimal amount1 = new BigDecimal("10.15");
        BigDecimal amount2 = new BigDecimal("35.12");
        BigDecimal sum = sumBinaryOperator.apply(amount1, amount2);
        System.out.printf("Sum of %s and %s is %s", amount1, amount2, sum);
        assertThat(sum, is(new BigDecimal("45.27")));
    }

    private UnaryOperator<String> getUnaryOperator() {

        UnaryOperator<String> toUpperCaseUnaryOperator = String::toUpperCase;
        return toUpperCaseUnaryOperator;
    }

    private BinaryOperator<BigDecimal> getBinaryOperator() {

        BinaryOperator<BigDecimal> sumBinaryOperator = new BinaryOperator<BigDecimal>() {
            @Override
            public BigDecimal apply(BigDecimal addend, BigDecimal augend) {
                return addend.add(augend);
            }
        };

        return sumBinaryOperator;
    }
}