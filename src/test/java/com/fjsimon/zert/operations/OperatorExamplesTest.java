package com.fjsimon.zert.operations;

import org.junit.Test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


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
public class OperatorExamplesTest {


    /**
     * +       Additive operator (also used for String concatenation)
     * -       Subtraction operator
     * *       Multiplication operator
     * /       Division operator
     * %       Remainder operator
     */

    @Test
    public void getArithmeticOperatorsOperation() {

        int result = 1 + 2;
        System.out.println("1 + 2 = " + result);
        int original_result = result;

        result = result - 1;
        System.out.println(original_result + " - 1 = " + result);
        original_result = result;

        result = result * 2;
        System.out.println(original_result + " * 2 = " + result);
        original_result = result;

        result = result / 2;
        System.out.println(original_result + " / 2 = " + result);
        original_result = result;

        result = result + 8;
        System.out.println(original_result + " + 8 = " + result);
        original_result = result;

        result = result % 7;
        System.out.println(original_result + " % 7 = " + result);

        assertThat(result, is(3));
    }

    /**
     * +       Unary plus operator; indicates positive value (numbers are positive without this, however)
     * -       Unary minus operator; negates an expression
     * ++      Increment operator; increments a value by 1
     * --      Decrement operator; decrements a value by 1
     * !       Logical complement operator; inverts the value of a boolean
     */
    @Test
    public void getUnaryOperatorsOperation() {

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

        assertThat(result, is(-1));
    }

    @Test
    public void getPrePostOperations() {

        int i = 3;
        assertThat(i    , is(3));
        assertThat(i++  , is(3));
        assertThat(i    , is(4));
        assertThat(++i  , is(5));
        assertThat(i    , is(5));
        assertThat(++i  , is(6));
        assertThat(i++  , is(6));
        assertThat(i    , is(7));
    }

    /**
     * ==      Equal to
     * !=      Not equal to
     * >       Greater than
     * >=      Greater than or equal to
     * <       Less than
     * <=      Less than or equal to
     */
    @Test
    public void getEqualityRelationalOperators() {

        int value1 = 1;
        int value2 = 2;

        assertThat(value1 == value2 , is(false));
        assertThat(value1 != value2 , is(true));
        assertThat(value1 > value2  , is(false));
        assertThat(value1 < value2  , is(true));
        assertThat(value1 <= value2 , is(true));
    }

    /**
     * &&      Conditional-AND
     * ||      Conditional-OR
     */
    @Test
    public void getConditionalOperators() {

        int value1 = 1;
        int value2 = 2;

        assertThat((value1 == 1) && (value2 == 2), is(true));
        assertThat((value1 == 1) || (value2 == 1), is(true));
    }

    /**
     * ?:      Ternary (shorthand for if-then-else statement)
     */
    @Test
    public void getTernaryOperation() {

        int value1 = 1;
        int value2 = 2;
        int result;
        boolean someCondition = true;
        result = someCondition ? value1 : value2;

        assertThat(result, is(1));
    }

    /**
     * instanceof      Compares an object to a specified type
     */
    @Test
    public void getTypeComparisonOperator() {

        Integer integer = new Integer(5);
        Number number = new Integer(5);

        assertThat(integer instanceof Number, is(true));
        assertThat(integer instanceof Integer, is(true));
        assertThat(integer instanceof Serializable, is(true));
        assertThat(integer instanceof Object, is(true));
        assertThat(integer instanceof Comparable, is(true));
        assertThat(number instanceof Double, is(false));
        assertThat(number instanceof Serializable, is(true));
        assertThat(number instanceof Comparable, is(true));

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

    @Test
    public void getBitwiseBitShiftOperators() {

        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"

        assertThat(val & bitmask, is(2));
    }

    @Test
    public void getBitShiftOperators() {

        byte n = 2; //0010
        byte a = 2; //0010
        byte b = 4; //0100

        assertThat(n, is((byte) 2));
        assertThat((byte) ~n, is((byte) -3));
        assertThat((byte) (a&b), is((byte) 0));
        assertThat((byte) (a|b), is((byte) 6));
        assertThat((byte) (a^b), is((byte) 6));
    }

    @Test
    public void getBooleanStringTest() {

        boolean x = true, z = true;
        int y = 20;
        x = (y != 10) ^ (z=false);

        assertThat(x + ", " + y + ", " + z, is("true, 20, false"));
    }

    class JustLooping {
        private int j;

        void showJ() {
            while (j <= 5) {
                for (int j = 1; j <= 5; ) {
                    System.out.print(j + " ");
                    j++;
                }
                j++;
            }
        }
    }

    @Test
    public void testQ02() {

        new JustLooping().showJ();
    }
}