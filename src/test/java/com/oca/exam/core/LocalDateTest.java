package com.oca.exam.core;

import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateTest {

    @Test(expected = DateTimeException.class)
    public void ch03q30() {
        LocalDate date = LocalDate.of(2018, Month.APRIL, 40);
        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
    }

    @Test
    public void ch03q31() {

        LocalDate date = LocalDate.of(2018, Month.APRIL, 30);
        date.plusDays(2);
        date.plusYears(3);
        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
    }
}
