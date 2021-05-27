package com.fjsimon.zert.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StringBuilderTest {

    @Test
    public void stringBuilderAppendTest(){

        StringBuilder sb = new StringBuilder("Hello ");
        sb.append("World");

        assertThat(sb.toString(), is("Hello World"));
    }

    @Test
    public void stringBuilderAppendIterTest() {

        StringBuilder sb = new StringBuilder();
        for(char current = 'a'; current <= 'z'; current++) {
            sb.append(current);
        }

        assertThat(sb.toString(), is("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void stringBuilderChainTest() {

        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b.append("f").append("g");
        List<StringBuilder> stringBuilderAppendChaining = Arrays.asList(a, b);

        assertThat(stringBuilderAppendChaining.get(0).toString(), is("abcdefg"));
        assertThat(stringBuilderAppendChaining.get(1).toString(), is("abcdefg"));
    }

    @Test
    public void stringBuilderInsertTest() {

        StringBuilder sb = new StringBuilder("Hello ");
        sb.insert(1, "World");

        assertThat(sb.toString(), is("HWorldello "));
    }

    @Test
    public void printStringBuilderMethodsTest() {

        StringBuilder sb = new StringBuilder("animals");
        String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
        int len = sb.length();
        char ch = sb.charAt(6);
        System.out.println("************************");
        System.out.printf("substring %s%nlength %d%ncharacter %c%n", sub, len, ch);

        StringBuilder sbd1 = new StringBuilder().append(1).append('c');
        sbd1.append("-").append(true);
        System.out.printf("append %s%n", sbd1.toString());


        StringBuilder sbd2 = new StringBuilder("animals");
        sbd2.insert(7, "-");
        sbd2.insert(0, "-");
        sbd2.insert(4, "-");
        System.out.printf("insert %s%n", sbd2.toString());

        StringBuilder sbd3 = new StringBuilder("abcdef");
        sbd3.delete(1, 3);  // adef
        sbd3.deleteCharAt(3); //ade
        System.out.printf("delete %s%n", sbd3.toString());

        StringBuilder sbd4 = new StringBuilder("ABC");
        sbd4.reverse();
        System.out.printf("reverse %s%n", sbd4.toString());
    }

    @Test
    public void printStringBuilderEqualityTest() {

        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        StringBuilder three = one.append("a");
        System.out.println("************************");
        System.out.println(one == two);
        System.out.println(one == three);

        String x = "Hello World";
        String y = "Hello World";
        System.out.println(x == y);

        String c1 = "Hello World";
        String c2 = " Hello World".trim();
        System.out.println(c1 == c2);

        String d1 = new String("Hello World");
        String d2 = "Hello World";
        System.out.println(d1 == d2);

        String e1 = "Hello World";
        String e2 = " Hello World".trim();
        System.out.println(e1.equals(e2));
    }

    public static void roar(String a, StringBuilder b) {

        a.concat("!!!");
        b.append(("!!!"));
    }

    @Test
    public void printRoarTest() {

        String s = "roar";
        StringBuilder sb = new StringBuilder("roar");
        roar(s, sb);

        assertThat(s, is("roar"));
        assertThat(sb.toString(), is("roar!!!"));
    }

    @Test
    public void c3e12() {

        System.out.println("************************");
        StringBuilder numbers = new StringBuilder("0123456789");
        numbers.delete(2, 8);
        numbers.append("-").insert(2, "+");
        System.out.println(numbers);
    }

    @Test
    public void c3e14() {

        StringBuilder puzzle1 = new StringBuilder("Java");
        System.out.println("************************");
        System.out.printf("puzzle1 = %s%n", puzzle1);
        System.out.printf("puzzle1.reverse() = %s%n", puzzle1.reverse());

        StringBuilder puzzle2 = new StringBuilder("Java");
        System.out.printf("puzzle2 = %s%n", puzzle2);
        System.out.printf("puzzle2.append(\"vaJ$\").delete(0,3).deleteCharAt(puzzle2.length() - 1) = %s%n",
                puzzle2.append("vaJ$").delete(0,3).deleteCharAt(puzzle2.length() - 1));
    }
}
