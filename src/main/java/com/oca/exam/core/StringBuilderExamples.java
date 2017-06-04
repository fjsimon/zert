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
    }

    public static StringBuilder getStringBuilderInsert(){

        StringBuilder sb = new StringBuilder("Hello ");
        sb.insert(1, "World");
        return sb;
    }

    public static void main(String...args) {
        printStringBuilderMethods();
    }


}
