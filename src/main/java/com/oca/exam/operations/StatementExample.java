package com.oca.exam.operations;


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

    public static int getNumDays(int month, int year){

        int numDays = 0;

        switch (month) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                numDays = 31;
                break;
            case 4: case 6:
            case 9: case 11:
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
}
