package com.oca.exam.core;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
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

    public static void main(String...args) {

        System.out.println("LocalDate.now " + getLocalDate());

        System.out.println("LocalDate Format " + getLocalDateFormat());

        System.out.println("LocalDate Format " + getLocalDateOf(2017, 10, 9));

        System.out.println("MonthDay " +getMonthDay());

        LocalDate today = LocalDate.now();
        System.out.println("Period (days) " + Period.between(today,
                getLocalDatePlus(today, 1L, ChronoUnit.WEEKS)).getDays());
        System.out.println("Period (days) " + Period.between(today,
                getLocalDatePlus(today, 1L, ChronoUnit.DAYS)).getDays());
        System.out.println("Period (years) " + Period.between(today,
                getLocalDatePlus(today, 1L, ChronoUnit.YEARS)).getYears());

        System.out.println("Period (days) " + Period.between(today,
                getLocalDateMinus(today, 1L, ChronoUnit.WEEKS)).getDays());
        System.out.println("Period (days) " + Period.between(today,
                getLocalDateMinus(today, 1L, ChronoUnit.DAYS)).getDays());
        System.out.println("Period (years) " + Period.between(today,
                getLocalDateMinus(today, 1L, ChronoUnit.YEARS)).getYears());
        System.out.println("Period " + getDifference());

        System.out.println("isLeapYear " + isLeapYear());

        String date = "20140116";
        LocalDate localDateFormatted = formatDate(date);
        System.out.printf("Date generated from String %s is %s %n", date, localDateFormatted);

        String parsedate = "Apr 18 2014";
        LocalDate localDate = LocalDateExamples.parseDate(parsedate).get();
        System.out.printf("Successfully parsed String %s, date is %s%n", parsedate, localDate);

        String localDateString = LocalDateExamples.getLocalDateTimeToString(LocalDateTime.now()).get();
        System.out.printf("Local Date at : %s %n", localDateString);
        System.out.printf("Local Date at : %s %n", LocalDate.now());
        System.out.printf("Local Date at : %s %n", LocalDate.of(2015, Month.JANUARY, 20));
        System.out.printf("Local Date at : %s %n", LocalDate.of(2015, 1, 20));
        System.out.printf("Local Date now plus 2 days : %s %n", LocalDate.now().plusDays(2));
        System.out.printf("Local Date now plus 2 weeks : %s %n", LocalDate.now().plusWeeks(2));
        System.out.printf("Local Date now plus 2 months : %s %n", LocalDate.now().plusMonths(2));
        System.out.printf("Local Date now plus 2 years : %s %n", LocalDate.now().plusYears(2));

//        LocalDate d = new LocalDate(); // DOES NOT COMPILE
//        LocalDate.of(2015, Month.JANUARY, 32); // java.time.DateTimeException
    }
}
