package com.oca.exam.core;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeTest {

    @Test
    public void zonedDateTimeTest() {

        ZoneId zoneId = ZoneId.of("America/New_York");
        LocalDateTime localDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localDateAndTime, zoneId);
        System.out.printf("Zoned Date Time New York %s %n", dateAndTimeInNewYork);
    }

    @Test
    public void differentTimeZoneAsiaTest(){

        DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM yyyy");

        LocalDateTime ldt = LocalDateTime.of(2016, Month.AUGUST, 22, 14, 30);
        System.out.println("LocalDateTime : " + format.format(ldt));

        //UTC+8
        ZonedDateTime klDateTime = ldt.atZone(ZoneId.of("Asia/Kuala_Lumpur"));
        System.out.println("Depart : " + format.format(klDateTime));

        //UTC+9 and flight duration = 7 hours
        ZonedDateTime japanDateTime = klDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo")).plusHours(7);
        System.out.println("Arrive : " + format.format(japanDateTime));

        System.out.println("\n---Detail---");
        System.out.println("Depart : " + klDateTime);
        System.out.println("Arrive : " + japanDateTime);
        System.out.printf("Duration (hours) between Kuala_Lumpur and Tokyo zone %s %n",
                Duration.between(klDateTime, japanDateTime).toHours());
    }

    @Test
    public void differentTimeZoneEuropeTest() {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM yyyy");

        //Convert String to LocalDateTime
        String date = "2016-08-22 14:30";
        LocalDateTime ldt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println("LocalDateTime : " + format.format(ldt));

        //Paris, 2016 Apr-Oct = DST, UTC+2, other months UTC+1
        //UTC+2
        ZonedDateTime parisDateTime = ldt.atZone(ZoneId.of("Europe/Paris"));
        System.out.println("Depart : " + format.format(parisDateTime));

        //hard code a zoneoffset like this, UTC-5
        ZoneOffset nyOffSet = ZoneOffset.of("-05:00");
        ZonedDateTime nyDateTime = parisDateTime.withZoneSameInstant(nyOffSet).plusHours(8).plusMinutes(10);
        System.out.println("Arrive : " + format.format(nyDateTime));

        System.out.println("\n---Detail---");
        System.out.println("Depart : " + parisDateTime);
        System.out.println("Arrive : " + nyDateTime);
        System.out.printf("Duration (hours) between Paris and New York time zone %s %n",
                Duration.between(parisDateTime, nyDateTime).toHours());
    }

    @Test
    public void timeZonesTest() {

        LocalDateTime nowDateTime = LocalDateTime.now();

        ZoneId montrealZone = ZoneId.of("America/Montreal");
        ZonedDateTime montrealZonedDateTime = ZonedDateTime.of(nowDateTime, montrealZone);
        System.out.printf("Montreal-zoned now date/time: %s %n", montrealZonedDateTime);

        ZoneId moscowZone = ZoneId.of("Europe/Moscow");
        ZonedDateTime moscowZonedDateTime = montrealZonedDateTime.withZoneSameInstant(moscowZone);
        System.out.printf("Moscow-zoned now date/time: %s %n", moscowZonedDateTime);

        // Typically the amount is zero during winter and one hour during summer.
        System.out.printf("Current daylight savings offset for [%s]: %s %n",
                moscowZone, moscowZone.getRules().getDaylightSavings(Instant.now()));
    }
}
