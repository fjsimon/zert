package com.fjsimon.zert.exceptions;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

public class JVMExceptionsTest extends BaseTest {

    @Test
    public void arrayIndexOutOfBoundsException() {

        try {
            int[] ia = new int[]{ 1, 2, 3}; // ia is of length 3.
            System.out.println(ia[3]); // Exception
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    @Test
    public void classCastException(){

        try {
            Object s = "asdf";
            StringBuffer sb = (StringBuffer) s; //exceptions at runtime because s is referring to a String.
        }catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void nullPointerException() {

        try {
            String s = null;
            System.out.println(s.length()); //NullPointerException at runtime because s is null.
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void arithmeticException() {
        try {
            int k = 10/0;
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
    }
}
