package com.oca.exam.datatypes;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InstanceVariableTest {

    @Test
    public void getResult(){

        assertThat(InstanceVariable.getResult(), is("aString = null, aBoolean = false, anInt = 0, " +
                "aDouble = 0.0, aLong = 0, aByte = 0, aShort = 0, aFloat = 0.0, aChar = \u0000"));
    }

    @Test
    public void getBinaryResult(){

        assertThat(InstanceVariable.getBinaryResult(), is("aInt = 5, aDouble = 5.0"));
    }

    @Test
    public void getHexResult(){

        assertThat(InstanceVariable.getHexResult(), is("aInt = 14, aDouble = 14.0"));
    }
}