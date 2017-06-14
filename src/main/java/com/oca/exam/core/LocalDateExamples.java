package com.oca.exam.core;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LocalDateExamples {


    private static LocalDate getLocalDate() {

        LocalDate today = LocalDate.now();
        return today;
    }

    private static String getLocalDateFormat() {

        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        return String.format("Year : %d Month : %d day : %d", year, month, day);
    }

    private static LocalDate getLocalDateOf(int year, int month, int day) {

        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        return dateOfBirth;
    }

    private static MonthDay getMonthDay() {

        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
        return MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
    }

    private static LocalDate getLocalDatePlus(LocalDate localDate, long amount, TemporalUnit temporalUnit) {

        return localDate.plus(amount, temporalUnit);
    }

    private static LocalDate getLocalDateMinus(LocalDate localDate, long amount, TemporalUnit temporalUnit) {

        return localDate.minus(amount, temporalUnit);
    }

    private static boolean isLeapYear() {

        return LocalDate.now().isLeapYear();
    }

    private static Period getDifference() {

        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        LocalDate today = LocalDate.now();
        Period periodToNextJavaRelease = Period.between(java8Release, today);
        return periodToNextJavaRelease;
    }

    private static LocalDate formatDate(String date) {

        LocalDate formatted = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        return formatted;
    }

    private static Optional<LocalDate> parseDate(String date) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate parseDate = LocalDate.parse(date, formatter);
            return Optional.of(parseDate);
        } catch (DateTimeParseException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    private static Optional<String> getLocalDateTimeToString(LocalDateTime localDateTime) {

        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            String landing = localDateTime.format(format);
            return Optional.of(landing);
        } catch (DateTimeException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    private static Map<String, String> getLocalDateTime(){

        Map<String, String> map = new HashMap<>();

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        map.put("Current DateTime", now.toString());
        map.put("date1", now.toLocalDate().toString());

        Month month = now.getMonth();
        int day = now.getDayOfMonth();
        int seconds = now.getSecond();
        map.put("date2","Month: " + month +" day: " + day +" seconds: " + seconds);

        LocalDateTime date3 = now.withDayOfMonth(10).withYear(2012);
        map.put("date3", date3.toString());

        LocalDate date4 = LocalDate.of(2014, Month.DECEMBER, 12);
        map.put("date4", date4.toString());

        LocalTime date5 = LocalTime.of(22, 15);
        map.put("date5", date5.toString());

        LocalTime date6 = LocalTime.parse("20:15:30");
        map.put("date6", date6.toString());

        return map;
    }

    public static void main(String...args) {

        System.out.println("LocalTime.now " + getLocalDate());

        System.out.println(getLocalDateFormat());

        System.out.println(getLocalDateOf(2017, 10, 9));

        System.out.println(getMonthDay());

        LocalDate today = LocalDate.now();
        System.out.println(Period.between(today, getLocalDatePlus(today, 1L, ChronoUnit.WEEKS)).getDays());
        System.out.println(Period.between(today, getLocalDatePlus(today, 1L, ChronoUnit.DAYS)).getDays());
        System.out.println(Period.between(today, getLocalDatePlus(today, 1L, ChronoUnit.YEARS)).getYears());

        System.out.println(Period.between(today, getLocalDateMinus(today, 1L, ChronoUnit.WEEKS)).getDays());
        System.out.println(Period.between(today, getLocalDateMinus(today, 1L, ChronoUnit.DAYS)).getDays());
        System.out.println(Period.between(today, getLocalDateMinus(today, 1L, ChronoUnit.YEARS)).getYears());

        System.out.println(isLeapYear());
        System.out.println("Get difference " + getDifference());

        String date = "20140116";
        LocalDate localDateFormatted = formatDate(date);
        System.out.printf("Date generated from String %s is %s %n", date, localDateFormatted);

        String parsedate = "Apr 18 2014";
        LocalDate localDate = LocalDateExamples.parseDate(parsedate).get();
        System.out.printf("Successfully parsed String %s, date is %s%n", parsedate, localDate);

        String localDateString = LocalDateExamples.getLocalDateTimeToString(LocalDateTime.now()).get();
        System.out.printf("Local Date at : %s %n", localDateString);

        System.out.println(LocalDateExamples.getLocalDateTime().get("Current DateTime"));
        System.out.println(LocalDateExamples.getLocalDateTime().get("date1"));
        System.out.println(LocalDateExamples.getLocalDateTime().get("date2"));
        System.out.println(LocalDateExamples.getLocalDateTime().get("date3"));
        System.out.println(LocalDateExamples.getLocalDateTime().get("date4"));
        System.out.println(LocalDateExamples.getLocalDateTime().get("date5"));
        System.out.println(LocalDateExamples.getLocalDateTime().get("date6"));
    }
}
