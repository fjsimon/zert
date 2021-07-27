package com.fjsimon.zert.operations;

import org.junit.Test;

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

    @Test
    public void getConditionalOperators() {

        Map<String, Boolean> map = OperatorExamples.getConditionalOperators();
        assertThat(map.get("value1 is 1 AND value2 is 2"), is(true));
        assertThat(map.get("value1 is 1 OR value2 is 1"), is(true));
    }

    @Test
    public void getTernaryOperation() {

        assertThat(OperatorExamples.getTernaryOperation(), is(1));
    }

    @Test
    public void getTypeComparisonOperator() {

        Map<String, Boolean> map = OperatorExamples.getTypeComparisonOperator();
        assertThat(map.get("obj1 instanceof Parent"), is(true));
        assertThat(map.get("obj1 instanceof Child"), is(false));
        assertThat(map.get("obj1 instanceof MyInterface"), is(false));
        assertThat(map.get("obj2 instanceof Parent"), is(true));
        assertThat(map.get("obj2 instanceof Child"), is(true));
        assertThat(map.get("obj2 instanceof MyInterface"), is(true));
    }

    @Test
    public void getBitwiseBitShiftOperators() {

        assertThat(OperatorExamples.getBitwiseBitShiftOperators(), is(2));
    }

    @Test
    public void getBitShiftOperators() {

        Map<String, Byte> map = OperatorExamples.getBitShiftOperators();
        assertThat(map.get("initial byte value"), is((byte) 2));
        assertThat(map.get("~byte"), is((byte) -3));
        assertThat(map.get("a bitwise AND b"), is((byte) 0));
        assertThat(map.get("a bitwise OR b"), is((byte) 6));
        assertThat(map.get("a XOR b"), is((byte) 6));
    }

    @Test
    public void getBooleanStringTest() {

        assertThat(OperatorExamples.getBooleanString(), is("true, 20, false"));
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