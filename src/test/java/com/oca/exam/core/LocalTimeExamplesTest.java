package com.oca.exam.core;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LocalTimeExamplesTest {

    @Test
    public void compareLocalTimeBefore(){
        LocalTime localTime = LocalTimeExamples.getLocalTime();
        System.out.println("Local time : " + localTime);
        assertThat("Compare Local time : ", localTime.isBefore(LocalTime.now()), is(true));
    }

    @Test
    public void addHoursToLocalTime(){
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2);
        System.out.println("Time after 2 hours : " + newTime);
        assertThat("Compare Local time : ", newTime.isAfter(LocalTime.now()), is(true));
    }

    @Test
    public void subtractHoursToLocalTime(){
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.minusHours(2);
        System.out.println("Time before 2 hours : " + newTime);
        assertThat("Compare Local time : ", newTime.isBefore(LocalTime.now()), is(true));
    }

}