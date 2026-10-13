package com.fjsimon.zert.exceptions;

import com.fjsimon.zert.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BaseTest.class)
public class JVMErrorsTest {

    public static class X {
        int k = 0;
        {
            k = 10/0; //throws java.lang.ArithmeticException but this is wrapped into a
            // ExceptionInInitializationError and thrown outside.
        }
    }

    @Test
    public void arithmeticExceptionTest() {

        try {
            X x = new X();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    private void overflow(int k) {
        overflow(k++);
    }

    @Disabled
    @Test
    public void stackOverflowError() {
        try {
            overflow(1);
        }catch (StackOverflowError e){
            e.printStackTrace();
        }
    }
}
