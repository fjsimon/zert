package com.fjsimon.zert;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class LambdaExamplesTest extends BaseTest {

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
