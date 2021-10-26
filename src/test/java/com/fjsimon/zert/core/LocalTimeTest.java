package com.fjsimon.zert.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeTest {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void localTimeTest() {

        LocalTime now = LocalTime.now();
        System.out.println("Local time : " + now);
        System.out.printf("Compare Local time : %s%n", now.isBefore(LocalTime.now()));

        LocalTime time = LocalTime.now();
        LocalTime newTimePlus = time.plusHours(2);
        System.out.println("Time after 2 hours : " + newTimePlus);
        System.out.printf("Compare Local time : %s%n", newTimePlus.isAfter(LocalTime.now()));

        LocalTime newTimeMinus = time.minusHours(2);
        System.out.println("Time before 2 hours : " + newTimeMinus);
        System.out.printf("Compare Local time : %s%n", newTimeMinus.isBefore(LocalTime.now()));

        LocalTime localTime = LocalTime.of(5, 15);
        System.out.println("Time : " + localTime);
        System.out.println("Time plus 1 hour : " + localTime.plusHours(1));
        System.out.println("Time plus 1 minute : " + localTime.plusMinutes(1));
        System.out.println("Time plus 10 seconds : " + localTime.plusSeconds(10));
        System.out.println("Time plus 100 nano seconds : " + localTime.plusNanos(100));
    }

    @Test
    public void localTimeExamTest() {

        /* LocalTime */
        LocalTime specificTime = LocalTime.of(21, 16, 59);
        System.out.printf("Specific time[21:16:59]: hour[%d], minute[%d], second[%d]%n",
                specificTime.getHour(),
                specificTime.getMinute(),
                specificTime.getSecond());

        LocalTime nowTime = LocalTime.now();
        System.out.printf("Now time: hour[%d], minute[%d], second[%d]%n",
                nowTime.get(ChronoField.HOUR_OF_DAY),
                nowTime.get(ChronoField.MINUTE_OF_HOUR),
                nowTime.get(ChronoField.SECOND_OF_MINUTE));
    }
}
