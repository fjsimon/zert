package com.fjsimon.zert.exceptions;

public class JVMExceptions {


    public static void arrayIndexOutOfBoundsException() {

        try {
            int[] ia = new int[]{ 1, 2, 3}; // ia is of length 3.
            System.out.println(ia[3]); // Exception
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public static void classCastException(){

        try {
            Object s = "asdf";
            StringBuffer sb = (StringBuffer) s; //exceptions at runtime because s is referring to a String.
        }catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public static void nullPointerException() {

        try {
            String s = null;
            System.out.println(s.length()); //NullPointerException at runtime because s is null.
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void arithmeticException() {
        try {
            int k = 10/0;
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
    }

    public static void main(String...args){

        arrayIndexOutOfBoundsException();
        classCastException();
        nullPointerException();
        arithmeticException();
    }
}
