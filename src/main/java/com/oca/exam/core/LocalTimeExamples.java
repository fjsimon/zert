package com.oca.exam.core;

import java.time.LocalTime;

public class LocalTimeExamples {

    public static void main(String ...args) {

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
}
