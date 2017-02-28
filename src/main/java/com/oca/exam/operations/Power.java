package com.oca.exam.operations;

public class Power {

    public static long pow(int x) {
        long y = x * (long) x;
        x = -1;
        return y;
    }

    public static void main(String... args){
        int value = 9;
        long result = pow(value);
        System.out.println(value); // 9
    }
}
