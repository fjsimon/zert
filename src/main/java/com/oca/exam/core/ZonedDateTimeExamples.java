package com.oca.exam.core;


import java.time.*;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeExamples {


    public static ZonedDateTime getZonedDateTime(String zone) {
        ZoneId zoneId = ZoneId.of(zone);
        LocalDateTime localDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localDateAndTime, zoneId);
        return dateAndTimeInNewYork;
    }

    public static Duration getDifferentTimeZoneExample1(){

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

        return Duration.between(klDateTime, japanDateTime);
    }


    public static Duration getDifferentTimeZoneExample2(){
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
        System.out.println("\n");

        return Duration.between(parisDateTime, nyDateTime);
    }

    public static void main(String...args) {

        ZonedDateTime dateAndTimeInNewYork = ZonedDateTimeExamples.getZonedDateTime("America/New_York");
        System.out.printf("Zoned Date Time New York %s %n", dateAndTimeInNewYork);

        Duration duration1 = getDifferentTimeZoneExample1();
        System.out.printf("Duration (hours) between Kuala_Lumpur and Tokyo zone %s %n", duration1.toHours());
        System.out.println("\n");

        Duration duration2 = getDifferentTimeZoneExample2();
        System.out.printf("Duration (hours) between Paris and New York time zone %s %n", duration2.toHours());
    }
}