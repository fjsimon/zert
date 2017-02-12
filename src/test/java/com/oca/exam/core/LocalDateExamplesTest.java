package com.oca.exam.core;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
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

    @Test
    public void getLocalDatePlus() {

        LocalDate today = LocalDate.now();
        Period period = Period.between(today, LocalDateExamples.getLocalDatePlus(today, 1L, ChronoUnit.WEEKS));
        assertThat(period.getDays(), is(7));

        period = Period.between(today, LocalDateExamples.getLocalDatePlus(today, 1L, ChronoUnit.DAYS));
        assertThat(period.getDays(), is(1));

        period = Period.between(today, LocalDateExamples.getLocalDatePlus(today, 1L, ChronoUnit.YEARS));
        assertThat(period.getYears(), is(1));
    }

    @Test
    public void getLocalDateMinus() {

        LocalDate today = LocalDate.now();
        Period period = Period.between(LocalDateExamples.getLocalDateMinus(today, 1L, ChronoUnit.WEEKS), today);
        assertThat(period.getDays(), is(7));

        period = Period.between(LocalDateExamples.getLocalDateMinus(today, 1L, ChronoUnit.DAYS), today);
        assertThat(period.getDays(), is(1));

        period = Period.between(LocalDateExamples.getLocalDateMinus(today, 1L, ChronoUnit.YEARS), today);
        assertThat(period.getYears(), is(1));
    }

    @Test
    public void isLeapYear(){

        assertThat(LocalDateExamples.isLeapYear(), is(LocalDate.now().isLeapYear()));
    }

    @Test
    public void getDifference(){

        assertThat(LocalDateExamples.getDifference(), is(not(nullValue())));
    }

    @Test
    public void getLocalDateFormatted(){

        String date = "20140116";
        LocalDate localDateFormatted = LocalDateExamples.formatDate(date);
        System.out.printf("Date generated from String %s is %s %n", date, localDateFormatted);
        assertThat(localDateFormatted.toString(), is("2014-01-16"));
    }

    @Test
    public void getParseDate(){

        String date = "Apr 18 2014";
        LocalDate localDate = LocalDateExamples.parseDate(date).get();
        System.out.printf("Successfully parsed String %s, date is %s%n", date, localDate);
        assertThat(localDate.toString(), is("2014-04-18"));
    }

    @Test
    public void getLocalDateTimeToString(){

        String localDate = LocalDateExamples.getLocalDateTimeToString(LocalDateTime.now()).get();
        System.out.printf("Local Date at : %s %n", localDate);
        assertThat(localDate, is(not(nullValue())));
    }

    @Test
    public void testLocalDateTime(){

        assertThat(LocalDateExamples.getLocalDateTime().get("Current DateTime"), is(not(nullValue())));
        assertThat(LocalDateExamples.getLocalDateTime().get("date1"), is(LocalDate.now().toString()));
        assertThat(LocalDateExamples.getLocalDateTime().get("date2"), is(not(nullValue())));
        assertThat(LocalDateExamples.getLocalDateTime().get("date3"), is(not(nullValue())));
        assertThat(LocalDateExamples.getLocalDateTime().get("date4"), is("2014-12-12"));
        assertThat(LocalDateExamples.getLocalDateTime().get("date5"), is("22:15"));
        assertThat(LocalDateExamples.getLocalDateTime().get("date6"), is("20:15:30"));
    }


}