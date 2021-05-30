package com.fjsimon.zert.datatypes;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class InstanceVariableTest {

    private byte aByte;
    private short aShort;
    private int anInt;
    private long aLong;
    private float aFloat;
    private double aDouble;
    private char aChar;
    private String aString;
    private boolean aBoolean;

    @Test
    public void defaultValuesTest(){

        System.out.printf("String %s %n", aString);
        System.out.printf("Boolean %b %n", aBoolean);
        System.out.printf("Integer %d %n", anInt);
        System.out.printf("Double %f %n", aDouble);
        System.out.printf("Byte %s %n", aByte);
        System.out.printf("Float %f %n", aFloat);
        System.out.printf("Char %s %n", aChar);


        assertThat(aString, is(nullValue()));
        assertThat(aBoolean, is(false));
        assertThat(anInt, is(0));
        assertThat(aDouble, is(0.0));
        assertThat(aByte, is((byte) 0));
        assertThat(aShort, is((short) 0));
        assertThat(aFloat, is(0f));
        assertThat(aChar, is('\u0000'));
    }

    @Test
    public void binaryResultTest(){
        int aInt = 0b101;
        double aDouble = 0b101;
        StringBuilder sb = new StringBuilder();
        sb.append("aInt = " + aInt);
        sb.append(", aDouble = " + aDouble);

        System.out.printf("%s%n", sb.toString());
        assertThat(sb.toString(), Matchers.is("aInt = 5, aDouble = 5.0"));
    }

    @Test
    public void hexResultTest(){
        int aInt = 0xE;
        double aDouble = 0xE;
        StringBuilder sb = new StringBuilder();
        sb.append("aInt = " + aInt);
        sb.append(", aDouble = " + aDouble);

        System.out.printf("%s%n", sb.toString());
        assertThat(sb.toString(), Matchers.is("aInt = 14, aDouble = 14.0"));
    }

}