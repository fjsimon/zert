package com.oca.exam.exception;


import java.util.Optional;

public class AppExceptions {


    public static void processData(byte[] data, int datatype) {
        if(datatype != 1 || datatype != 2)
            throw new IllegalArgumentException();
    }

    public static void illegalArgumentException() {
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

    public static void illegalStateException() {

        try {
            of(null);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public static void numberFormatException(){
        try {
            Integer.parseInt("asf");
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    public static void main(String...args){

        illegalArgumentException();
        illegalStateException();
        numberFormatException();
    }
}
