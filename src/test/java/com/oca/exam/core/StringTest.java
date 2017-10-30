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

}
