package com.oca.exam.core;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;
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
}
