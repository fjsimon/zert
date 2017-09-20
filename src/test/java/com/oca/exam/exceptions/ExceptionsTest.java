package com.oca.exam.exceptions;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExceptionsTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setup(){
        System.setOut(new PrintStream(outputStream));
    }

    public float parseFloat(String s){
        float f = 0.0f;
        try{
            f = Float.valueOf(s).floatValue();
            return f ;
        }
        catch(NumberFormatException nfe){
            System.out.println("Invalid input " + s);
            f = Float.NaN ;
            return f;
        }
        finally { System.out.println("finally");  }

    }

    @Test
    public void test03_Q04() {

        assertThat(parseFloat("1"), is(1.0F));
        assertThat(String.format("finally%n"), CoreMatchers.is(outputStream.toString()));
    }

    @Test
    public void test02_Q57(){

        int k = 0;
        try{
            int i = 5/k;
        } catch (ArithmeticException e){
            System.out.println("1");
        } catch (RuntimeException e){
            System.out.println("2");
            return ;
        } catch (Exception e){
            System.out.println("3");
        } finally{
            System.out.println("4");
        }
        System.out.println("5");

        assertThat(String.format("%s%n%s%n%s%n", 1,4,5), CoreMatchers.is(outputStream.toString()));
    }

    public void myMethod() throws Exception{
        yourMethod();
    }

    public void yourMethod() throws Exception{
        throw new Exception();
    }

    @Test(expected = Exception.class)
    public void test02_Q65() throws Exception {
        myMethod();
    }

    public void test02_Q66() {
        int x = 1;
        int y = 0;
//        if( x/y ) System.out.println("Good");
//        else  System.out.println("Bad");
    }

    class MyException extends Throwable{}
    class MyException1 extends MyException{}
    class MyException2 extends MyException{}
    class MyException3 extends MyException2{}

    void myMethodEx() throws MyException {
        throw new MyException3();
    }

    @Test
    public void test02_Q04(){

        try {
            myMethodEx();
        } catch(MyException me) {
            System.out.println("MyException thrown");
        }
//        catch(MyException3 me3){
//            System.out.println("MyException3 thrown");
//        }
        finally {
            System.out.println(" Done");
        }

        assertThat(String.format("%s%n%s%n", "MyException thrown", " Done"), CoreMatchers.is(outputStream.toString()));
    }

    static int val() throws Exception {
        throw new Exception("unimplemented");
    }

    @Test
    public void test04_Q37() {

        int[][] a = { { 00, 01 }, { 10, 11 } };
        int i = 99;
        try {
            a[val()][i = 1]++;
        } catch (Exception e) {
            System.out.println( i+", "+a[1][1]);
        }

        assertThat(String.format("%s,%s%n", "99", " 11"), CoreMatchers.is(outputStream.toString()));
    }

}
