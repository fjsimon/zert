package com.oca.exam.core;

import java.time.LocalDate;
import java.time.MonthDay;

public class LocalDateExamples {


    public static LocalDate getLocalDate(){
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

    public static LocalDate getLocalDateOf(int year, int month, int day){
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        return dateOfBirth;
    }

    public static MonthDay getMonthDay(){
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
        return MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
    }
}
