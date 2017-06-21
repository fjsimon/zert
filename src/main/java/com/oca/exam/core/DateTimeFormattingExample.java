package com.oca.exam.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormattingExample {

    private static void formattingDatesAndTimes() {

        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11,12,34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime.format(dateTime));
        System.out.println(shortDateTime.format(date));
//        System.out.println(shortDateTime.format(time)); // UnsupportedTemporalTypeException

        // Print same as the previous code
        System.out.println(dateTime.format(shortDateTime));
        System.out.println(date.format(shortDateTime));
//        System.out.println(time.format(shortDateTime)); // UnsupportedTemporalTypeException

    }

    public static void main(String... args) {

        LocalDate nowLocalDate = LocalDate.now();
        System.out.printf("Now date in ISO date format: %s %n",
                nowLocalDate.format(DateTimeFormatter.ISO_DATE));
        System.out.printf("Now date/time in ISO date/time format: %s %n",
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        String ddMMyyyyPattern = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ddMMyyyyPattern);
        String formattedDate = nowLocalDate.format(formatter);
        System.out.printf("Now date in [%s] format: %s %n", ddMMyyyyPattern, formattedDate);
        System.out.printf("Parsed formatted now date[%s]: %s %n", formattedDate,
                LocalDate.parse(formattedDate, formatter));

        // http://www.localeplanet.com/java/fr-CA/
        String dMMMMyyyyPattern = "d MMMM yyyy";
        DateTimeFormatter canadianFrenchFormatter =
                DateTimeFormatter.ofPattern(dMMMMyyyyPattern, Locale.CANADA_FRENCH);
        System.out.printf("Now date in [%s] format and [%s] locale: %s %n",
                dMMMMyyyyPattern, Locale.CANADA_FRENCH,
                nowLocalDate.format(canadianFrenchFormatter));

        formattingDatesAndTimes();
    }
}
