package com.oca.exam.operations;


import java.util.ArrayList;
import java.util.List;

public class StatementExample {

    /**
     * The statements inside your source files are generally executed from top to bottom, in the order that they appear.
     * Control flow statements, however, break up the flow of execution by employing decision making,
     * looping, and branching, enabling your program to conditionally execute particular blocks of code.
     * This section describes the decision-making statements (if-then, if-then-else, switch),
     * the looping statements (for, while, do-while), and the branching statements (break, continue, return)
     * supported by the Java programming language.
     */


    public static char getGrade(int testscore) {

        char grade;
        if (testscore >= 90) {
            grade = 'A';
        } else if (testscore >= 80) {
            grade = 'B';
        } else if (testscore >= 70) {
            grade = 'C';
        } else if (testscore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        return grade;
    }

    public static String getMonth(int month) {

        String monthString;
        switch (month) {
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
                monthString = "Invalid month";
                break;
        }

        return monthString;
    }

    public static int getNumDays(int month, int year) {

        int numDays = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                if (((year % 4 == 0) &&
                        !(year % 100 == 0))
                        || (year % 400 == 0))
                    numDays = 29;
                else
                    numDays = 28;
                break;
            default:
                System.out.println("Invalid month.");
                break;
        }

        return numDays;
    }

    public static int getWhileCount() {

        int count = 1;
        while (count < 11) {
            count++;
        }

        return count;
    }

    public static int getDoWhileCount() {

        int count = 1;
        do {
            count++;
        } while (count < 11);

        return count;
    }

    public static int getForCount() {
        int count = 1;
        for (int i = 1; i < 11; i++) {
            count++;
        }

        return count;
    }

    public static int getForEachCount() {

        int count = 0;
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int item : numbers) {
            count += item;
        }

        return count;
    }

    public static String searchForUsingBreak(int searchfor) {
        int[] arrayOfInts = {32, 87, 3, 589, 12, 1076, 2000, 8, 622, 127};

        int i;
        boolean foundIt = false;

        for (i = 0; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] == searchfor) {
                foundIt = true;
                break;
            }
        }

        if (foundIt) {
            return "Found " + searchfor + " at index " + i;
        } else {
            return searchfor + " not in the array";
        }
    }

    public static String searchForUsingBreakLabel(int searchfor) {
        int[][] arrayOfInts = {
                {32, 87, 3, 589},
                {12, 1076, 2000, 8},
                {622, 127, 77, 955}
        };

        int i;
        int j = 0;
        boolean foundIt = false;

        search:
        for (i = 0; i < arrayOfInts.length; i++) {
            for (j = 0; j < arrayOfInts[i].length; j++) {
                if (arrayOfInts[i][j] == searchfor) {
                    foundIt = true;
                    break search;
                }
            }
        }

        if (foundIt) {
            return "Found " + searchfor + " at " + i + ", " + j;
        } else {
            return searchfor + " not in the array";
        }
    }

    public static String searchBreakStatementLabel(int searchValue) {
        int[][] list = {
                {1, 13, 5},
                {1, 2, 5},
                {2, 7, 2}
        };

        int positionX = -1;
        int positionY = -1;
        boolean foundIt = false;

        PARENT_LOOP:
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {

                if (list[i][j] == searchValue) {
                    positionX = i;
                    positionY = j;
                    break PARENT_LOOP;
                }
            }
        }

        if (positionX == -1 || positionY == -1) {
            return searchValue + " not in the array";
        } else {
            return "Found " + searchValue + " at (" + positionX + ", " + positionY + ")";
        }
    }

    public static String foundCharUsingContinue(char letter) {

        String searchMe = "peter piper picked a " + "peck of pickled peppers";
        int max = searchMe.length();
        int numPs = 0;

        for (int i = 0; i < max; i++) {
            // interested only in p's
            if (searchMe.charAt(i) != letter)
                continue;

            // process p's
            numPs++;
        }
        return String.format("Found " + numPs + " %c's in the string.", letter);

    }

    public static String foundSubstringUsingContinueWithLabel(String substring) {

        String searchMe = "Look for a substring in me";
        boolean foundIt = false;

        int max = searchMe.length() - substring.length();

        test:
        for (int i = 0; i <= max; i++) {
            int n = substring.length();
            int j = i;
            int k = 0;
            while (n-- != 0) {
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    continue test;
                }
            }
            foundIt = true;
            break test;
        }
        return foundIt ? "Found it" : "Didn't find it";

    }

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
