package com.oca.exam.datatypes;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class InstanceVariableTest {

    @Test
    public void getDefaultValues(){

        assertThat(InstanceVariable.getDefaultValues().get("aString"), is(nullValue()));
        assertThat(InstanceVariable.getDefaultValues().get("aBoolean"), is(false));
        assertThat(InstanceVariable.getDefaultValues().get("anInt"), is(0));
        assertThat(InstanceVariable.getDefaultValues().get("aDouble"), is(0.0));
        assertThat(InstanceVariable.getDefaultValues().get("aByte"), is((byte) 0));
        assertThat(InstanceVariable.getDefaultValues().get("aShort"), is((short) 0));
        assertThat(InstanceVariable.getDefaultValues().get("aFloat"), is(0f));
        assertThat(InstanceVariable.getDefaultValues().get("aChar"), is('\u0000'));
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