package com.fjsimon.zert.operations;

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

    @Test
    public void continueStatementTest(){

        assertThat(StatementExample.continueLabelStatement().size(), is(3));
        assertThat(StatementExample.continueLabelStatement().toString(),
                is("[ 1a,  3a,  4a]"));

        assertThat(StatementExample.continueStatement().size(), is(6));
        assertThat(StatementExample.continueStatement().toString(),
                is("[ 1a,  1c,  3a,  3c,  4a,  4c]"));

        assertThat(StatementExample.noContinueStatement().size(), is(12));
        assertThat(StatementExample.noContinueStatement().toString(),
                is("[ 1a,  1b,  1c,  2a,  2b,  2c,  3a,  3b,  3c,  4a,  4b,  4c]"));
    }

    @Test
    public void getTernaryValueTest(){
        assertThat(StatementExample.getTernaryValue(), is(8));
    }

    @Test
    public void getKeepGoingResultTest() {

        assertThat(StatementExample.getKeepGoingResult(), is(11));
    }

    @Test
    public void getCountValueTest() {

        assertThat(StatementExample.getCountValue(), is(1));
    }

    @Test
    public void getWhileValueTest() {

        assertThat(StatementExample.getWhileValue(), is(36));
    }
}