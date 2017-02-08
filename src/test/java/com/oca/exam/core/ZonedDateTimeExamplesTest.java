package com.oca.exam.core;

import org.junit.Test;

import java.time.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class ZonedDateTimeExamplesTest {

    @Test
    public void getZonedDateTime() {

        ZonedDateTime dateAndTimeInNewYork = ZonedDateTimeExamples.getZonedDateTime("America/New_York");
        assertThat(dateAndTimeInNewYork, is(not(nullValue())));
    }

    @Test
    public void getDifferentTimeZoneExample1() {

        Duration duration = ZonedDateTimeExamples.getDifferentTimeZoneExample1();
        assertThat(duration.toHours(), is(7L));
    }

    @Test
    public void getDifferentTimeZoneExample2() {

        Duration duration = ZonedDateTimeExamples.getDifferentTimeZoneExample2();
        assertThat(duration.toHours(), is(8L));
    }

}