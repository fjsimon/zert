package com.fjsimon.zert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BaseTest.class)
public class LambdaExamplesTest {

    @Test
    public void testLambdaExpression() {

        assertTrue( test(i -> i == 5));
        assertTrue( test((i) -> i == 5));
        assertTrue( test((i) -> { return i == 5;}));
    }

    private static boolean test(Predicate<Integer> p) {

        return p.test(5);
    }
}
