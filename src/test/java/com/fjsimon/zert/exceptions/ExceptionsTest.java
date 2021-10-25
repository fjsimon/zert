package com.fjsimon.zert.exceptions;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExceptionsTest {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void test02_Q57() {

        int k = 0;
        try {
            int i = 5 / k;
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (RuntimeException e) {
            System.out.println("2");
            return;
        } catch (Exception e) {
            System.out.println("3");
        } finally {
            System.out.println("4");
        }
        System.out.println("5");
    }

    public void myMethod() throws Exception {
        yourMethod();
    }

    public void yourMethod() throws Exception {
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

    class MyException extends Throwable {
    }

    class MyException1 extends MyException {
    }

    class MyException2 extends MyException {
    }

    class MyException3 extends MyException2 {
    }

    void myMethodEx() throws MyException {
        throw new MyException3();
    }

    @Test
    public void test02_Q04() {

        try {
            myMethodEx();
        } catch (MyException me) {
            System.out.println("MyException thrown");
        }
//        catch(MyException3 me3){
//            System.out.println("MyException3 thrown");
//        }
        finally {
            System.out.println("Done");
        }

    }

    @Test
    public void catchExceptionTest(){

        assertThat(catchException(), is("abcde"));
    }

    private static String catchException() {

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

//class PortConnector {
//    public PortConnector(int port) { //throws IOException {
//        if (Math.random() > 0.5) {
//            throw new IOException();
//        }
//        throw new RuntimeException();
//    }
//}
//class TestClass2 {
//    public static void main(String[] args) { //throws IOException {
//        try {
//            PortConnector pc = new PortConnector(10);
//        } catch (RuntimeException re) {
//            re.printStackTrace();
//        }
//    }
//}