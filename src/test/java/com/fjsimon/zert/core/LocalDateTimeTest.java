package com.fjsimon.zert.core;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LocalDateTimeTest extends BaseTest {


    @Test
    public void localDateTimeTest() {

        LocalDate specificDate = LocalDate.of(2016, 2, 15);
        LocalTime specificTime = LocalTime.of(21, 16, 59);

        /* LocalDateTime */
        System.out.printf("Parsing specific date[2015-02-24]: %s %n", LocalDate.parse("2015-02-24"));
        System.out.printf("Parsing specific time[23:54:08]: %s %n", LocalTime.parse("23:54:08"));

        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.printf("Now date/time: %s %n", nowDateTime);

        LocalDateTime specificDateTime = LocalDateTime.of(1940, Month.JANUARY, 20, 0, 0, 1);
        System.out.printf("Specific date/time 1: %s %n", specificDateTime);
        System.out.printf("Specific date/time 2: %s %n", LocalDateTime.of(specificDate, specificTime));
        System.out.printf("Specific date/time 3: %s %n", specificDate.atTime(specificTime));
        System.out.printf("Specific date/time 4: %s %n", specificTime.atDate(specificDate));

        assertThat(LocalDateTime.of(specificDate, specificTime).toString(), is("2016-02-15T21:16:59"));
        assertThat(specificDateTime.toString(), is("1940-01-20T00:00:01"));
    }

    @Test()
    public void ch03q32() {

        LocalDateTime date = LocalDateTime.of(2015, 5,10,11,22,33);
        Period p = Period.of(1,2,3);
        date = date.minus(p);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(date.format(f));
    }

    @Test()
    public void ch03q33() {

        LocalDateTime date = LocalDateTime.of(2015, 5,10,11,22,33);
        Period p = Period.ofDays(1).ofYears(2);
        date = date.minus(p);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(f.format(date));
    }


}
