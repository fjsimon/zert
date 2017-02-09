package com.oca.exam.operations;

import org.junit.Test;

import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OperatorExamplesTest {

    @Test
    public void getArithmeticOperatorsOperation() {

        assertThat(OperatorExamples.getArithmeticOperatorsOperation(), is(3));
    }

    @Test
    public void getUnaryOperatorsOperation() {

        assertThat(OperatorExamples.getUnaryOperatorsOperation(), is(-1));
    }

    @Test
    public void getPrePostOperations() {

        assertThat(OperatorExamples.getPrePostOperations(), is(7));
    }

    @Test
    public void getEqualityRelationalOperators() {

        Map<String, Boolean> map = OperatorExamples.getEqualityRelationalOperators();
        assertThat(map.get("value1 == value2"), is(false));
        assertThat(map.get("value1 != value2"), is(true));
        assertThat(map.get("value1 > value2"), is(false));
        assertThat(map.get("value1 < value2"), is(true));
        assertThat(map.get("value1 <= value2"), is(true));
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

}