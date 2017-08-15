package com.oca.exam.exception;

public class JVMErrors {

    public static class X {
        int k = 0;
        {
            k = 10/0; //throws java.lang.ArithmeticException but this is wrapped into a
            // ExceptionInInitializationError and thrown outside.
        }
    }

    public static void stackOverflowError(int k) {
        try {
            stackOverflowError(k++);
        }catch (StackOverflowError e){
            e.printStackTrace();
        }
    }

    public static void main(String...args) {

        try {
            X x = new X();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        stackOverflowError(1);
    }
}
