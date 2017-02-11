package com.oca.exam.datatypes;

import java.util.HashMap;
import java.util.Map;

public class InstanceVariable {

    private byte aByte;
    private short aShort;
    private int anInt;
    private long aLong;
    private float aFloat;
    private double aDouble;
    private char aChar;
    private String aString;
    private boolean aBoolean;


    public static Map<String, Object> getDefaultValues(){
        InstanceVariable instanceVariable = new InstanceVariable();

        Map map = new HashMap();
        map.put("aString", instanceVariable.aString);
        map.put("aBoolean", instanceVariable.aBoolean);
        map.put("anInt", instanceVariable.anInt);
        map.put("aDouble", instanceVariable.aDouble);
        map.put("aLong", instanceVariable.aLong);
        map.put("aByte", instanceVariable.aByte);
        map.put("aShort", instanceVariable.aShort);
        map.put("aFloat", instanceVariable.aFloat);
        map.put("aChar", instanceVariable.aChar);
        return map;
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
