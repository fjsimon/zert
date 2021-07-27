package com.fjsimon.zert.operations;

import java.util.HashMap;
import java.util.Map;


public class OperatorExamples {

    /**
     * ?:      Ternary (shorthand for if-then-else statement)
     */
    public static int getTernaryOperation() {

        int value1 = 1;
        int value2 = 2;
        int result;
        boolean someCondition = true;
        result = someCondition ? value1 : value2;
        return result;
    }

    /**
     * instanceof      Compares an object to a specified type
     */
    public static Map<String, Boolean> getTypeComparisonOperator() {

        Parent obj1 = new Parent();
        Parent obj2 = new Child();

        Map<String, Boolean> map = new HashMap<>();
        map.put("obj1 instanceof Parent", obj1 instanceof Parent);
        map.put("obj1 instanceof Child", obj1 instanceof Child);
        map.put("obj1 instanceof MyInterface", obj1 instanceof MyInterface);
        map.put("obj2 instanceof Parent", obj2 instanceof Parent);
        map.put("obj2 instanceof Child", obj2 instanceof Child);
        map.put("obj2 instanceof MyInterface", obj2 instanceof MyInterface);
        return map;
    }

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

class Parent {
}

class Child extends Parent implements MyInterface {
}

interface MyInterface {
}