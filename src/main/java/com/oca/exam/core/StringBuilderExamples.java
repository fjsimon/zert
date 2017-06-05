package com.oca.exam.core;

import java.util.Arrays;
import java.util.List;

public class StringBuilderExamples {


    public static StringBuilder getStringBuilderAppend(){

        StringBuilder sb = new StringBuilder("Hello ");
        sb.append("World");
        return sb;
    }

    public static StringBuilder getStringBuilderAppendIter() {

        StringBuilder alpha = new StringBuilder();

        for(char current = 'a'; current <= 'z'; current++) {
            alpha.append(current);
        }

        return alpha;
    }

    public static List<StringBuilder> getStringBuilderAppendChaining() {

        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b.append("f").append("g");
        return Arrays.asList(a,b);
    }

    public static void printStringBuilderMethods() {

        StringBuilder sb = new StringBuilder("animals");
        String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
        int len = sb.length();
        char ch = sb.charAt(6);
        System.out.println(String.format("substring %s%nlength %d%ncharacter %c%n", sub, len, ch));

        StringBuilder sbd1 = new StringBuilder().append(1).append('c');
        sbd1.append("-").append(true);
        System.out.println(String.format("append %s%n", sbd1.toString()));


        StringBuilder sbd2 = new StringBuilder("animals");
        sbd2.insert(7, "-");
        sbd2.insert(0, "-");
        sbd2.insert(4, "-");
        System.out.println(String.format("insert %s%n", sbd2.toString()));

        StringBuilder sbd3 = new StringBuilder("abcdef");
        sbd3.delete(1, 3);  // adef
        sbd3.deleteCharAt(3); //ade
        System.out.println(String.format("delete %s%n", sbd3.toString()));

        StringBuilder sbd4 = new StringBuilder("ABC");
        sbd4.reverse();
        System.out.println(String.format("reverse %s%n", sbd4.toString()));

    }

    public static void printStringBuilderEquality() {

        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        StringBuilder three = one.append("a");
        System.out.println(one == two);
        System.out.println(one == three);

        String x = "Hello World";
        String y = "Hello World";
        System.out.println(x == y);

        String c1 = "Hello World";
        String c2 = " Hello World".trim();
        System.out.println(c1 == c2);

        String d1 = new String("Hello World");
        String d2 = "Hello World";
        System.out.println(d1 == d2);

        String e1 = "Hello World";
        String e2 = " Hello World".trim();
        System.out.println(e1.equals(e2));
    }

    public static StringBuilder getStringBuilderInsert(){

        StringBuilder sb = new StringBuilder("Hello ");
        sb.insert(1, "World");
        return sb;
    }

    public static void main(String...args) {

        printStringBuilderMethods();
        printStringBuilderEquality();
    }


}
