package com.oca.exam.core;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class LocalDateTimeTest {

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

    @Test()
    public void test05_Q64() {

        try {

//            LocalDateTime greatDay = LocalDateTime.parse("2015-01-01T11:44:44.789");//2
            LocalDateTime greatDay = LocalDateTime.parse("2015-01-01");//2
            fail();
            String greatDayStr = greatDay.format(DateTimeFormatter.ISO_DATE_TIME); //3
            System.out.println(greatDayStr);//4
        }catch (DateTimeParseException e){

            assertThat(e.getMessage(), is("Text '2015-01-01' could not be parsed at index 10"));
        }
    }
}
