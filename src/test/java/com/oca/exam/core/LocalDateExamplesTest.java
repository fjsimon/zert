package com.oca.exam.core;

import org.junit.Test;

import java.time.LocalDate;
import java.time.MonthDay;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LocalDateExamplesTest {

    @Test
    public void getLocalDate() {

        assertThat("Today's Local date : ", LocalDateExamples.getLocalDate(), is(LocalDate.now()));
    }

    @Test
    public void getLocalDateFormat() {

        assertThat(LocalDateExamples.getLocalDateFormat(), is("Year : " + LocalDate.now().getYear()
                + " Month : " + LocalDate.now().getMonthValue()
                + " day : " + LocalDate.now().getDayOfMonth()));
    }

    @Test
    public void getLocalDateOf() {

        assertThat(LocalDateExamples.getLocalDateOf(2017, 10, 9), is(LocalDate.of(2017, 10, 9)));
    }

    @Test
    public void getMonthDay() {

        assertThat(LocalDateExamples.getMonthDay(), is(MonthDay.from(LocalDate.now())));
    }


}