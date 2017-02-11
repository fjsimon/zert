package com.oca.exam.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StatementExampleTest {

    @Test
    public void getGradeTest(){

        assertThat(StatementExample.getGrade(76), is('C'));
    }

    @Test
    public void getMonth(){

        assertThat(StatementExample.getMonth(10), is("October"));
    }

    @Test
    public void getNumDays(){

        assertThat(StatementExample.getNumDays(2, 2017), is(28));
        assertThat(StatementExample.getNumDays(10, 2017), is(31));
        assertThat(StatementExample.getNumDays(11, 2017), is(30));
    }

    @Test
    public void getCount(){

        assertThat(StatementExample.getWhileCount(), is(11));
        assertThat(StatementExample.getDoWhileCount(), is(11));
    }
}