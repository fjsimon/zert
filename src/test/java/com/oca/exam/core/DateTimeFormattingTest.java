package com.oca.exam.core;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DateTimeFormattingTest {


    @Test
    public void formattingDate_test() {

        LocalDate d1 = LocalDate.parse("2015-02-05", DateTimeFormatter.ISO_DATE);
        LocalDate d2 = LocalDate.of(2015, 2, 5);
        LocalDate d3 = LocalDate.now();

        assertThat(d1.toString(), is("2015-02-05"));
        assertThat(d2.toString(), is("2015-02-05"));

    }
}
