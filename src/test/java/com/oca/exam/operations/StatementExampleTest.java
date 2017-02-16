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
    public void getCountExamplesTest(){

        assertThat(StatementExample.getWhileCount(), is(11));

        assertThat(StatementExample.getDoWhileCount(), is(11));

        assertThat(StatementExample.getForCount(), is(11));

        assertThat(StatementExample.getForEachCount(), is(55));
    }

    @Test
    public void searchForTest(){

        assertThat(StatementExample.searchForUsingBreak(12), is("Found 12 at index 4"));

        assertThat(StatementExample.searchForUsingBreakLabel(12), is("Found 12 at 1, 0"));

        assertThat(StatementExample.searchBreakStatementLabel(13), is("Found 13 at (0, 1)"));

    }

    @Test
    public void foundCharTest(){

        assertThat(StatementExample.foundCharUsingContinue('p'), is("Found 9 p's in the string."));
    }

    @Test
    public void foundSubstringTest(){

        assertThat(StatementExample.foundSubstringUsingContinueWithLabel("sub"), is("Found it"));
    }
}