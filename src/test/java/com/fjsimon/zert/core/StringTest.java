package com.fjsimon.zert.core;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class OtherString{ static String hello = "Hello"; }

public class StringTest extends BaseTest {

    public static void op(String st) {

        System.out.printf("st = %s%n", st);
        st += " world!!!";
        System.out.printf("st = %s%n", st);
    }

    @Test
    public void stringTest() {
        String string = "hola";
        op(string);
        System.out.printf("string = %s%n", string);

        assertThat(string, is("hola"));
    }

    @Test
    public void compareStringTest() {

        String hello = "Hello", lo = "lo";
        System.out.println("************************");
        System.out.printf("hello = \"%s\"%n", hello);
        System.out.printf("lo = \"%s\"%n", lo);

        System.out.printf("hello == \"Hello\" is %b%n", hello == "Hello");
        System.out.printf("OtherString.hello == \"Hello\" is %b%n", OtherString.hello == "Hello");
        System.out.printf("(hello == (\"Hel\"+\"lo\")) is %b%n", (hello == ("Hel"+"lo")));
        System.out.printf("(hello == (\"Hel\"+lo)) is %b%n", (hello == ("Hel"+lo)));
        System.out.printf("hello == (\"Hel\"+lo).intern() is %b%n", hello == ("Hel"+lo).intern());

    }

    @Test
    public void unicodeEscapes() {

        System.out.println("************************");
        System.out.printf("The Unicode encoding of the character %s%n", "\\u2122=\u2122");
    }

    @Test
    public void concatenationString() {

        String s1 = "1";
        String s2 = s1.concat("2");
        s2.concat("3");
        System.out.println("************************");
        System.out.printf("The result is \"%s\"%n", s2);


        String s3 = "1";
        String s4 = s3 + "2";
//        s3 + "3"; // It is an expression. Compilation error
        System.out.printf("The result is \"%s\"%n", s4 + 3);
        System.out.printf("The result is \"%s\"%n", s4);

    }

    @Test
    public void printSubstringsTest() {

        String numbers = "012345678";
        System.out.println("************************");
        System.out.printf("numbers is \"%s\"%n", numbers);
        System.out.printf("numbers.substring(1, 3) is \"%s\"%n", numbers.substring(1, 3));
        System.out.printf("numbers.substring(7, 7) is \"%s\"%n", numbers.substring(7, 7));
        System.out.printf("numbers.substring(7) is \"%s\"%n", numbers.substring(7));
    }

    @Test
    public void c3q9() {

        String s = "purr";
        System.out.println("************************");
        s.toUpperCase();
        s.trim();
        s.substring(1, 3);
        s += " two";
        System.out.printf("Length equals to %d%n",  s.length());
    }

    @Test
    public void c3e10() {

        String a = "";
        System.out.println("************************");
        a += 2;
        a += 'c';
        a += false;
        if(a == "2cfalse") System.out.println("==");
        if(a.equals("2cfalse")) System.out.println("equals");
    }
}
