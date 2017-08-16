package com.oca.exam.core;

public class StringExamples {


    public static void unicodeEscapes() {

        System.out.println("************************");
        System.out.printf("The Unicode encoding of the character %s%n", "\\u2122=\u2122");
    }

    public static void concatenationString() {

        String s1 = "1";
        String s2 = s1.concat("2");
        s2.concat("3");
        System.out.println("************************");
        System.out.printf("The result is %s%n", s2);


        String s3 = "1";
        String s4 = s3 + "2";
//        s3 + "3"; // It is an expression. Compilation error
        System.out.printf("The result is %s%n", s4 + 3);
        System.out.printf("The result is %s%n", s4);

    }

    public static void compareString() {

        String hello = "Hello", lo = "lo";
        System.out.println("************************");
        System.out.printf("hello = %s%n", hello);
        System.out.printf("lo = %s%n", lo);

        System.out.printf("hello == \"Hello\" is %b%n", hello == "Hello");
        System.out.printf("OtherString.hello == \"Hello\" is %b%n", OtherString.hello == "Hello");
        System.out.printf("(hello == (\"Hel\"+\"lo\")) is %b%n", (hello == ("Hel"+"lo")));
        System.out.printf("(hello == (\"Hel\"+lo)) is %b%n", (hello == ("Hel"+lo)));
        System.out.printf("hello == (\"Hel\"+lo).intern() is %b%n", hello == ("Hel"+lo).intern());

    }

    public static void printSubstrings() {

        String numbers = "012345678";
        System.out.println("************************");
        System.out.printf("numbers is \'%s\' %n", numbers);
        System.out.printf("numbers.substring(1, 3) is \'%s\' %n", numbers.substring(1, 3));
        System.out.printf("numbers.substring(7, 7) is \'%s\' %n", numbers.substring(7, 7));
        System.out.printf("numbers.substring(7) is \'%s\' %n", numbers.substring(7));
    }

    public static void main(String...args) {

        unicodeEscapes();
        concatenationString();
        compareString();
        printSubstrings();
    }

}

class OtherString{ static String hello = "Hello"; }