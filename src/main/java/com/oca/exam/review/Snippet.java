package com.oca.exam.review;

public class Snippet {

    public static String catchException() {

        String result = "a";
        try{
            result += "b";
            throw new IllegalArgumentException();
        }catch (RuntimeException e){
            result += "c";
        }finally {
            result += "d";
        }
        result += "e";
        return result;
    }
}
