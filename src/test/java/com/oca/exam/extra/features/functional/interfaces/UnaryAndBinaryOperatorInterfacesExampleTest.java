package com.oca.exam.extra.features.functional.interfaces;


import com.oca.exam.extra.features.collection.operations.CalculationsExample;
import com.oca.exam.extra.features.common.FuturamaCharacter;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class UnaryAndBinaryOperatorInterfacesExampleTest {

    @Test
    public void futuramaCharactersTest(){

        UnaryAndBinaryOperatorInterfacesExample ex = new UnaryAndBinaryOperatorInterfacesExample();
        List<FuturamaCharacter> characters = ex.getFuturamaCharacters();
        assertThat(characters, is(not(nullValue())));

        UnaryOperator<String> toUpperCaseUnaryOperator = ex.getUnaryOperator();

        for (FuturamaCharacter c : characters) {
            System.out.println("Full name: " + c.getFirstName() + " "
                    + toUpperCaseUnaryOperator.apply(c.getLastName()));
        }

        // the same, one-liner
        characters.forEach(c -> System.out.println("Full name: " + c.getFirstName() + " " +
                toUpperCaseUnaryOperator.apply(c.getLastName())));

        BinaryOperator<BigDecimal> sumBinaryOperator = ex.getBinaryOperator();

        BigDecimal amount1 = new BigDecimal("10.15");
        BigDecimal amount2 = new BigDecimal("35.12");
        BigDecimal sum = sumBinaryOperator.apply(amount1, amount2);
        System.out.printf("Sum of %s and %s is %s", amount1, amount2, sum);
        assertThat(sum, is(new BigDecimal("45.27")));
    }
}