package com.fjsimon.zert.operations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class StatementExampleTest {

    /**
     * The statements inside your source files are generally executed from top to bottom, in the order that they appear.
     * Control flow statements, however, break up the flow of execution by employing decision making,
     * looping, and branching, enabling your program to conditionally execute particular blocks of code.
     * This section describes the decision-making statements (if-then, if-then-else, switch),
     * the looping statements (for, while, do-while), and the branching statements (break, continue, return)
     * supported by the Java programming language.
     */

    @Test
    public void getGradeTest(){

        assertThat(getGrade(76), is('C'));
    }

    private static char getGrade(int testscore) {

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

    @Test
    public void getMonth(){

        assertThat(getMonth(10), is("October"));
    }

    private static String getMonth(int month) {

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

    @Test
    public void getNumDays(){

        assertThat(getNumDays(2, 2017), is(28));

        assertThat(getNumDays(10, 2017), is(31));

        assertThat(getNumDays(11, 2017), is(30));
    }

    private static int getNumDays(int month, int year) {

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

    @Test
    public void getCountExamplesTest(){

        assertThat(getWhileCount(), is(11));

        assertThat(getDoWhileCount(), is(11));

        assertThat(getForCount(), is(11));

        assertThat(getForEachCount(), is(55));
    }

    private static int getWhileCount() {

        int count = 1;
        while (count < 11) {
            count++;
        }

        return count;
    }

    private static int getDoWhileCount() {

        int count = 1;
        do {
            count++;
        } while (count < 11);

        return count;
    }

    private static int getForCount() {
        int count = 1;
        for (int i = 1; i < 11; i++) {
            count++;
        }

        return count;
    }

    private static int getForEachCount() {

        int count = 0;
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int item : numbers) {
            count += item;
        }

        return count;
    }

    @Test
    public void searchForTest(){

        assertThat(searchForUsingBreak(12), is("Found 12 at index 4"));

        assertThat(searchForUsingBreakLabel(12), is("Found 12 at 1, 0"));

        assertThat(searchBreakStatementLabel(13), is("Found 13 at (0, 1)"));

    }

    private static String searchForUsingBreak(int searchfor) {
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

    private static String searchForUsingBreakLabel(int searchfor) {
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

    private static String searchBreakStatementLabel(int searchValue) {
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

    @Test
    public void foundCharTest(){

        assertThat(foundCharUsingContinue('p'), is("Found 9 p's in the string."));
    }

    private static String foundCharUsingContinue(char letter) {

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

    @Test
    public void foundSubstringTest(){

        assertThat(foundSubstringUsingContinueWithLabel("sub"), is("Found it"));
    }

    private static String foundSubstringUsingContinueWithLabel(String substring) {

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

    @Test
    public void continueStatementTest(){

        assertThat(continueLabelStatement().size(), is(3));
        assertThat(continueLabelStatement().toString(),
                is("[ 1a,  3a,  4a]"));

        assertThat(continueStatement().size(), is(6));
        assertThat(continueStatement().toString(),
                is("[ 1a,  1c,  3a,  3c,  4a,  4c]"));

        assertThat(noContinueStatement().size(), is(12));
        assertThat(noContinueStatement().toString(),
                is("[ 1a,  1b,  1c,  2a,  2b,  2c,  3a,  3b,  3c,  4a,  4b,  4c]"));
    }

    private static List<String> continueLabelStatement() {

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

    private static List<String> continueStatement() {

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

    private static List<String> noContinueStatement() {

        List<String> result = new ArrayList();
        FIRST_CHAR_LOOP:
        for (int a = 1; a <= 4; a++) {
            for (char x = 'a'; x <= 'c'; x++) {
                result.add(" " + a + x);
            }
        }

        return result;
    }

    @Test
    public void getTernaryValueTest(){
        assertThat(getTernaryValue(), is(8));
    }

    private static int getTernaryValue() {

        int x = 5;
        return x > 2 ? x < 4 ? 10 : 8 : 7;
    }

    @Test
    public void getKeepGoingResultTest() {

        assertThat(getKeepGoingResult(), is(11));
    }

    private static int getKeepGoingResult() {
        boolean keepGoing = true;
        int result = 15, i = 10;
        do {
            i--;
            if (i == 8) keepGoing = false;
            result -= 2;
        } while (keepGoing);
        return result;
    }


    @Test
    public void getCountValueTest() {

        assertThat(getCountValue(), is(1));
    }

    private static int getCountValue() {
        int count = 0;
        ROW_LOOP : for(int row = 1; row <= 1; row++){
            for(int col = 1; col <= 2; col++) {
                if(row * col % 2 == 0) continue ROW_LOOP;
                count++;
            }
        }
        return count;
    }

    @Test
    public void getWhileValueTest() {

        assertThat(getWhileValue(), is(36));
    }

    private static int getWhileValue() {
        int m = 9, n = 1, x = 0;
        while (m > n) {
            m--;
            n += 2;
            x += m + n;
        }
        return x;
    }

}