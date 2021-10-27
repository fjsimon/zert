package com.fjsimon.zert.exceptions;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import java.util.Optional;

public class AppExceptionsTest extends BaseTest {

    public static void processData(byte[] data, int datatype) {
        if(datatype != 1 || datatype != 2)
            throw new IllegalArgumentException();
    }

    @Test
    public void illegalArgumentException() {
        try {
            processData(new byte[3], 3);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public static <T> Optional<T> of(T reference) {
        if (reference == null) {
            throw new IllegalStateException("Optional.of() must be passed a non-null reference");
        } else {
            return Optional.of(reference);
        }
    }

    @Test
    public void illegalStateException() {

        try {
            of(null);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void numberFormatException(){
        try {
            Integer.parseInt("asf");
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
}
