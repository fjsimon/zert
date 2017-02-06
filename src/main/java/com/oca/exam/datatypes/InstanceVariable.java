package com.oca.exam.datatypes;

public class InstanceVariable {

    private String aString;
    private boolean aBoolean;
    private int anInt;
    private double aDouble;
    private long aLong;
    private byte aByte;
    private short aShort;
    private float aFloat;
    private char aChar;


    public static String getResult(){
        InstanceVariable instanceVariable = new InstanceVariable();

        StringBuilder sb = new StringBuilder();
        sb.append("aString = " + instanceVariable.aString);
        sb.append(", aBoolean = " + instanceVariable.aBoolean);
        sb.append(", anInt = " + instanceVariable.anInt);
        sb.append(", aDouble = " + instanceVariable.aDouble);
        sb.append(", aLong = " + instanceVariable.aLong);
        sb.append(", aByte = " + instanceVariable.aByte);
        sb.append(", aShort = " + instanceVariable.aShort);
        sb.append(", aFloat = " + instanceVariable.aFloat);
        sb.append(", aChar = " + instanceVariable.aChar);

        return sb.toString();
    }

    public static String getBinaryResult(){
        int aInt = 0b101;
        double aDouble = 0b101;
        StringBuilder sb = new StringBuilder();
        sb.append("aInt = " + aInt);
        sb.append(", aDouble = " + aDouble);
        return sb.toString();
    }

    public static String getHexResult(){
        int aInt = 0xE;
        double aDouble = 0xE;

        StringBuilder sb = new StringBuilder();
        sb.append("aInt = " + aInt);
        sb.append(", aDouble = " + aDouble);
        return sb.toString();
    }



}
