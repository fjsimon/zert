package com.fjsimon.zert.operations;

import java.util.HashMap;
import java.util.Map;


public class OperatorExamples {


    /**
     *  Bitwise and Bit Shift Operators
     *  ~       Unary bitwise complement
     *  <<      Signed left shift
     *  >>      Signed right shift
     *  >>>     Unsigned right shift
     *  &       Bitwise AND
     *  ^       Bitwise exclusive OR
     *  |       Bitwise inclusive OR
     */
    public static int getBitwiseBitShiftOperators(){
        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        return val & bitmask;
    }

    public static Map<String, Byte> getBitShiftOperators(){

        byte n = 2; //0010
        byte a = 2; //0010
        byte b = 4; //0100

        Map<String, Byte> map = new HashMap<>();
        map.put("initial byte value", n);
        map.put("~byte", (byte) ~n);
        map.put("a bitwise AND b", (byte) (a&b));
        map.put("a bitwise OR b", (byte) (a|b));
        map.put("a XOR b", (byte) (a^b));
        return map;
    }

    public static String getBooleanString(){
        boolean x = true, z = true;
        int y = 20;
        x = (y != 10) ^ (z=false);
        return x + ", " + y + ", " + z;
    }

}