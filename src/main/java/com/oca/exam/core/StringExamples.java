package com.oca.exam.core;

public class StringExamples {


    private static void unicodeEscapes() {

        System.out.println("************************");
        System.out.printf("The Unicode encoding of the character %s%n", "\\u2122=\u2122");
    }

    private static void concatenationString() {

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

    private static void compareString() {

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

    private static void printSubstrings() {

        String numbers = "012345678";
        System.out.println("************************");
        System.out.printf("numbers is \'%s\' %n", numbers);
        System.out.printf("numbers.substring(1, 3) is \'%s\' %n", numbers.substring(1, 3));
        System.out.printf("numbers.substring(7, 7) is \'%s\' %n", numbers.substring(7, 7));
        System.out.printf("numbers.substring(7) is \'%s\' %n", numbers.substring(7));
    }

    private static void c3q9() {

        String s = "purr";
        System.out.println("************************");
        s.toUpperCase();
        s.trim();
        s.substring(1, 3);
        s += " two";
        System.out.printf("Length equals to %d%n",  s.length());
    }

    private static void c3e10() {

        String a = "";
        System.out.println("************************");
        a += 2;
        a += 'c';
        a += false;
        if(a == "2cfalse") System.out.println("==");
        if(a.equals("2cfalse")) System.out.println("equals");
    }

    public static void main(String...args) {

        unicodeEscapes();
        concatenationString();
        compareString();
        printSubstrings();
        c3q9();
        c3e10();
    }

}

class OtherString{ static String hello = "Hello"; }