package com.fjsimon.zert.operations;


import java.util.ArrayList;
import java.util.List;

public class StatementExample {


    public static List<String> continueLabelStatement() {

        List<String> result = new ArrayList();
        FIRST_CHAR_LOOP:
        for (int a = 1; a <= 4; a++) {
            for (char x = 'a'; x <= 'c'; x++) {

                if (a == 2 || x == 'b')
                    continue FIRST_CHAR_LOOP;
                result.add(" " + a + x);
            }
        }

        return result;
    }

    public static List<String> continueStatement() {

        List<String> result = new ArrayList();
        FIRST_CHAR_LOOP:
        for (int a = 1; a <= 4; a++) {
            for (char x = 'a'; x <= 'c'; x++) {

                if (a == 2 || x == 'b')
                    continue;
                result.add(" " + a + x);
            }
        }

        return result;
    }

    public static List<String> noContinueStatement() {

        List<String> result = new ArrayList();
        FIRST_CHAR_LOOP:
        for (int a = 1; a <= 4; a++) {
            for (char x = 'a'; x <= 'c'; x++) {
                result.add(" " + a + x);
            }
        }

        return result;
    }

    public static int getTernaryValue() {

        int x = 5;
        return x > 2 ? x < 4 ? 10 : 8 : 7;
    }

    public static int getKeepGoingResult() {
        boolean keepGoing = true;
        int result = 15, i = 10;
        do {
            i--;
            if (i == 8) keepGoing = false;
            result -= 2;
        } while (keepGoing);
        return result;
    }

    public static int getCountValue() {
        int count = 0;
        ROW_LOOP : for(int row = 1; row <= 1; row++){
            for(int col = 1; col <= 2; col++) {
                if(row * col % 2 == 0) continue ROW_LOOP;
                count++;
            }
        }
        return count;
    }

    public static int getWhileValue() {
        int m = 9, n = 1, x = 0;
        while (m > n) {
            m--;
            n += 2;
            x += m + n;
        }
        return x;
    }
}
