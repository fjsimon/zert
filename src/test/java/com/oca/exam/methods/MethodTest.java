package com.oca.exam.methods;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MethodTest {

    public static void printSum(int a, int b) {
        System.out.println("In int "+(a+b));
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println("In Integer "+(a+b));
    }

    public static void printSum(double a, double b) {
        System.out.println("In double "+(a+b));
    }

    @Test
    public void test03_Q06(){

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        printSum(1, 2);
        assertThat("In int 3\n", is(outputStream.toString()));
    }

    public static void processStacks(Stack x1, Stack x2) {

        x1.push (new Integer ("100")); //assume that the method push adds the passed object to the stack.
        x2 = x1;
    }

    @Test
    public void test01_stack() {

        Stack s1 = new Stack ();
        Stack s2 = new Stack ();
        processStacks (s1,s2);
        System.out.println (s1 + "    "+ s2);
    }

    class Base {
        public Object getValue(){ return new Object(); } //1
    }

    class Base2 extends Base {
        public String getValue(){ return "hello"; } //2
    }

    @Test
    public void test01_base() {

        Base b = new Base2();
        assertThat(b.getValue(), is("hello")); //3
    }

    void probe(Integer x) { System.out.println("In Integer"); } //2
    void probe(Object x) { System.out.println("In Object"); } //3
    void probe(Long x) { System.out.println("In Long"); } //4

    @Test
    public void test01_Q18() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String a = "hello";
        probe(a);
        assertThat("In Object\n", is(outputStream.toString()));
    }
}
