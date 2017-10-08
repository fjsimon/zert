package com.oca.exam.core;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void test04_Q20() {

        String String = "string isa string";
        System.out.println(String.substring(3, 6));
        assertThat(String.format("%s%n", "ing"), CoreMatchers.is(outputStream.toString()));
    }

    @Test
    public void test06_Q24() {

        assertThat("String".replace('g', 'G') == "String".replace('g', 'G'),
                is(false));

        assertThat("String".replace('g', 'g') ==
                new String("String").replace('g', 'g'), is(false));

        assertThat("String".replace('g', 'G') == "StrinG", is(false));

        assertThat("String".replace('g', 'g') == "String", is(true));

    }

    @Test
    public void test06_Q66() {

        String fullPhoneNumber = "ddd-ddd-dddd";

        assertThat(new StringBuilder(fullPhoneNumber).substring(0, 8)+"xxxx",
                is("ddd-ddd-xxxx"));
        assertThat(new StringBuilder(fullPhoneNumber).replace(8, 12, "xxxx").toString(),
                is("ddd-ddd-xxxx"));
//        assertThat(new StringBuilder(fullPhoneNumber).append("xxxx", 8, 12).toString(),
//                is("ddd-ddd-xxxx"));
        assertThat(new StringBuilder("xxxx").append(fullPhoneNumber, 0, 8).toString(),
                is("xxxxddd-ddd-"));
        assertThat(new StringBuilder("xxxx").insert(0, fullPhoneNumber, 0, 8).toString(),
                is("ddd-ddd-xxxx"));
    }
}
