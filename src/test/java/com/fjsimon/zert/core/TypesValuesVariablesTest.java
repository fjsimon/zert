package com.fjsimon.zert.core;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**

 Primitive Types and Values
 PrimitiveType:
 {Annotation} NumericType
 {Annotation} boolean

 NumericType:
 IntegralType
 FloatingPointType

 IntegralType:
 (one of)
 byte short int long char

 FloatingPointType:
 (one of)
 float double

 */
public class TypesValuesVariablesTest {

    @Test
    public void integerOperationTest() {
        int i = 1000000;
        System.out.println(i * i);
        long l = i;
        System.out.println(l * l);
//        System.out.println(20296 / (l - i)); // ArithmeticException in the division by l - i (0).
    }

    @Test
    public void floatingPointOperationTest() {

        // An example of overflow:
        double d = 1e308;
        System.out.print("overflow produces infinity: ");
        System.out.println(d + "*10==" + d*10);

        // An example of gradual underflow:
        d = 1e-305 * Math.PI;
        System.out.print("gradual underflow: " + d + "\n   ");
        for (int i = 0; i < 4; i++)
            System.out.print(" " + (d /= 100000));
        System.out.println();

        // An example of NaN:
        System.out.print("0.0/0.0 is Not-a-Number: ");
        d = 0.0/0.0;
        System.out.println(d);

        // An example of inexact results and rounding:
        System.out.print("inexact results with float:");
        for (int i = 0; i < 100; i++) {
            float z = 1.0f / i;
            if (z * i != 1.0f)
                System.out.print(" " + i);
        }
        System.out.println();

        // Another example of inexact results and rounding:
        System.out.print("inexact results with double:");
        for (int i = 0; i < 100; i++) {
            double z = 1.0 / i;
            if (z * i != 1.0)
                System.out.print(" " + i);
        }
        System.out.println();

        // An example of cast to integer rounding:
        System.out.print("cast to int rounds toward 0: ");
        d = 12345.6;
        System.out.println((int)d + " " + (int)(-d));
    }

    @Test
    public void integerLiteralsTest() {

        // The number 26, in decimal
        int decVal = 26;
        //  The number 26, in hexadecimal
        int hexVal = 0x1a;
        // The number 26, in binary
        int binVal = 0b11010;


        assertThat(decVal, is(26));
        assertThat(hexVal, is(26));
        assertThat(binVal, is(26));
    }

    @Test
    public void floatingPointLiteralsTest() {

        double d1 = 123.4;
        // same value as d1, but in scientific notation
        double d2 = 1.234e2;

        assertThat(d1 == d2, is(true));

    }
}
