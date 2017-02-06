package com.oca.exam.core;

public class StringBuilderExamples {


    public static StringBuilder getStringBuilderAppend(){

        StringBuilder sb = new StringBuilder("Hello ");
        sb.append("World");
        return sb;
    }

    public static StringBuilder getStringBuilderInsert(){

        StringBuilder sb = new StringBuilder("Hello ");
        sb.insert(1, "World");
        return sb;
    }



}
