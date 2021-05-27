package com.fjsimon.zert.operations;

import org.junit.Test;

public class IntOperationsTest {

    @Test
    public void testQ37(){
        int expr1 = 3 + 5 * 9 - 7;
        int expr2 = 3 + (5 * 9) - 7;
        int expr3 = 3 + 5 * (9 - 7);
        int expr4 = (3 + 5) * 9 - 7;
        System.out.printf("%d %d %d %d", expr1, expr2, expr3, expr4);
    }
}
