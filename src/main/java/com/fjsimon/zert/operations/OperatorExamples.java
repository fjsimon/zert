package com.fjsimon.zert.operations;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Operator Precedence
 * Operators	Precedence
 * postfix	expr++ expr--
 * unary	++expr --expr +expr -expr ~ !
 * multiplicative	* / %
 * additive	+ -
 * shift	<< >> >>>
 * relational	< > <= >= instanceof
 * equality	== !=
 * bitwise AND	&
 * bitwise exclusive OR	^
 * bitwise inclusive OR	|
 * logical AND	&&
 * logical OR	||
 * ternary	? :
 * assignment	= += -= *= /= %= &= ^= |= <<= >>= >>>=
 *
 */
public class OperatorExamples {


    /**
     * +       Unary plus operator; indicates positive value (numbers are positive without this, however)
     * -       Unary minus operator; negates an expression
     * ++      Increment operator; increments a value by 1
     * --      Decrement operator; decrements a value by 1
     * !       Logical complement operator; inverts the value of a boolean
     */
    public static int getUnaryOperatorsOperation() {

        int result = +1;
        System.out.println(result);

        result--;
        System.out.println(result);

        result++;
        System.out.println(result);

        result = -result;
        System.out.println(result);

        boolean success = false;
        System.out.println(success);
        System.out.println(!success);

        return result;
    }

    public static Map<String, Integer> getPrePostOperations() {

        Map<String, Integer> map = new HashMap();
        int i = 3;
        map.put("0 i", i);
        i++;
        map.put("1 i", i);
        ++i;
        map.put("2 i", i);
        map.put("3 i", i);
        map.put("4 ++i", ++i);
        map.put("5 i++", i++);
        map.put("6 i", i);
        return map;
    }

    /**
     * ==      Equal to
     * !=      Not equal to
     * >       Greater than
     * >=      Greater than or equal to
     * <       Less than
     * <=      Less than or equal to
     */
    public static Map<String, Boolean> getEqualityRelationalOperators() {

        int value1 = 1;
        int value2 = 2;

        Map<String, Boolean> map = new HashMap<>();
        map.put("value1 == value2", value1 == value2);
        map.put("value1 != value2", value1 != value2);
        map.put("value1 > value2", value1 > value2);
        map.put("value1 < value2", value1 < value2);
        map.put("value1 <= value2", value1 <= value2);
        return map;
    }

    /**
     * &&      Conditional-AND
     * ||      Conditional-OR
     */
    public static Map<String, Boolean> getConditionalOperators() {

        int value1 = 1;
        int value2 = 2;

        Map<String, Boolean> map = new HashMap<>();
        map.put("value1 is 1 AND value2 is 2", (value1 == 1) && (value2 == 2));
        map.put("value1 is 1 OR value2 is 1", (value1 == 1) || (value2 == 1));
        return map;
    }

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