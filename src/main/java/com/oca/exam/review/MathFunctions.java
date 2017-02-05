package com.oca.exam.review;

public class MathFunctions {

    public static void addToInt(int x, int amountToAdd){
        x = x + amountToAdd;
    }

    public static int getResult(){
        int a = 15;
        int b = 10;
        MathFunctions.addToInt(a, b);
        return a;
    }
}
