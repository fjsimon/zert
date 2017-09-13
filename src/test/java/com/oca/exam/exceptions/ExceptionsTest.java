package com.oca.exam.exceptions;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExceptionsTest {

    public float parseFloat(String s){
        float f = 0.0f;
        try{
            f = Float.valueOf(s).floatValue();
            return f ;
        }
        catch(NumberFormatException nfe){
            System.out.println("Invalid input " + s);
            f = Float.NaN ;
            return f;
        }
        finally { System.out.println("finally");  }

    }

    @Test
    public void test3Q04() {

        assertThat(parseFloat("1"), is(1.0F));
    }
}
