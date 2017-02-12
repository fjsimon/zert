package com.oca.exam.core;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LocalDateExamples {


    public static LocalDate getLocalDate() {
        LocalDate today = LocalDate.now();
        return today;
    }

    public static String getLocalDateFormat() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        return String.format("Year : %d Month : %d day : %d", year, month, day);
    }

    public static LocalDate getLocalDateOf(int year, int month, int day) {
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        return dateOfBirth;
    }

    public static MonthDay getMonthDay() {
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
        return MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
    }

    public static LocalDate getLocalDatePlus(LocalDate localDate, long amount, TemporalUnit temporalUnit) {
        return localDate.plus(amount, temporalUnit);
    }

    public static LocalDate getLocalDateMinus(LocalDate localDate, long amount, TemporalUnit temporalUnit) {
        return localDate.minus(amount, temporalUnit);
    }

    public static boolean isLeapYear() {
        return LocalDate.now().isLeapYear();
    }

    public static Period getDifference() {

        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        LocalDate today = LocalDate.now();
        Period periodToNextJavaRelease = Period.between(java8Release, today);
        return periodToNextJavaRelease;
    }

    public static LocalDate formatDate(String date) {

        LocalDate formatted = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        return formatted;
    }

    public static Optional<LocalDate> parseDate(String date) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate parseDate = LocalDate.parse(date, formatter);
            return Optional.of(parseDate);
        } catch (DateTimeParseException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    public static Optional<String> getLocalDateTimeToString(LocalDateTime localDateTime) {

        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            String landing = localDateTime.format(format);
            return Optional.of(landing);
        } catch (DateTimeException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    public static Map<String, String> getLocalDateTime(){

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
}
