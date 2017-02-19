package com.oca.exam.extra.features.functional.interfaces;

import com.oca.exam.extra.features.common.FuturamaCharacter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;


public class UnaryAndBinaryOperatorInterfacesExample {


    public List<FuturamaCharacter> getFuturamaCharacters() {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez"),
                new FuturamaCharacter("Philip", "Fry"),
                new FuturamaCharacter("Amy", "Wong")
        );

        System.out.println("Futurama characters:");
        characters.forEach(System.out::println); // c -> System.out.println(c)
        return characters;
    }

    public UnaryOperator<String> getUnaryOperator(){
        UnaryOperator<String> toUpperCaseUnaryOperator = String::toUpperCase;
        return toUpperCaseUnaryOperator;
    }

    public BinaryOperator<BigDecimal> getBinaryOperator(){
        BinaryOperator<BigDecimal> sumBinaryOperator = new BinaryOperator<BigDecimal>() {
            @Override
            public BigDecimal apply(BigDecimal addend, BigDecimal augend) {
                return addend.add(augend);
            }
        };

        return sumBinaryOperator;
    }
}
