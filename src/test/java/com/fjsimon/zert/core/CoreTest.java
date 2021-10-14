package com.fjsimon.zert.core;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CoreTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setup(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void test() {

        assertTrue(Boolean.parseBoolean("true"));

        assertFalse(Boolean.parseBoolean("TrUe") == new Boolean(null));

        assertFalse(new Boolean("TrUe") == new Boolean(true));

//        System.out.println(new Boolean() == false); // No Compile

        assertFalse(new Boolean("true") == Boolean.TRUE);

        assertTrue(new Boolean("no") == false);

        assertTrue(Boolean.parseBoolean("true"));

        assertFalse(new Boolean(null));

//        System.out.println(new Boolean());

        assertTrue(new Boolean("true"));

        assertTrue(new Boolean("trUE"));

    }

    @Test
    public void classname_test() {

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("mrx");
        String s = sb.toString();
        list.add(s);

        assertThat(s.getClass().toString(), is("class java.lang.String"));
        assertThat(list.getClass().toString(), is("class java.util.ArrayList"));
    }

    @Test
    public void test01_Q56() {

        ClassB b = new ClassB();
        b.method();
        assertThat(String.format("%d%n%d%n", 0, 4), CoreMatchers.is(outputStream.toString()));
    }

    @Test
    public void test01_Init() {

        ClassInit classInit = new ClassInit();
        assertThat(String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "a", "b", "c", "2", "3", "4", "1"),
                CoreMatchers.is(outputStream.toString()));
    }

    @Test
    public void stringFromCharTest(){
        String myStr = "good";
        char[] myCharArr = {'g', 'o', 'o', 'd' };

        String newStr = null;
        for(char ch : myCharArr){
            newStr = newStr + ch;
        }

        assertThat((newStr == myStr)+ " " + (newStr.equals(myStr)), is("false false"));
        assertThat(newStr, is("nullgood"));
        assertThat(myStr, is("good"));
    }

    @Test
    public void test01_Q49() {

        String s = "MINIMUM";
        assertThat(s.substring(4, 7), is("MUM")); //1
        assertThat(s.substring(5), is("UM")); //2
        assertThat(s.substring(s.indexOf('I', 3)), is("IMUM")); //3
        try {
            s.substring(s.indexOf('I', 4)); //4
            fail();
        }catch (StringIndexOutOfBoundsException e){

        }
    }

    @Test
    public void printerWriterTest(){
        OutputStreamWriter osw  =  new OutputStreamWriter( System.out );

        PrintWriter pw = new PrintWriter(osw);

        pw.write("hello");
        pw.close();
    }


}

class ClassA {

    ClassA() { print(); }
    void print() { System.out.println("A"); }
}

class ClassB extends ClassA {

    int i =   4;
    public void method() { print(); }
    void print() { System.out.println(i); }
}

class ClassInit{

    public ClassInit(){ s1 = sM1("1"); }
    static String s1 = sM1("a");
    String s3 = sM1("2");
    { s1 = sM1("3"); }
    static{ s1 = sM1("b"); }
    static String s2 = sM1("c");
    String s4 = sM1("4");

    private static String sM1(String s){

        System.out.println(s);
        return s;
    }
}



