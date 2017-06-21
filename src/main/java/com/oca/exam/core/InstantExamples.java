package com.oca.exam.core;

import java.time.Instant;

public class InstantExamples {

    public static Instant getInstant() {

        Instant timestamp = Instant.now();
        return timestamp;
    }

    public static void main(String ...args) {
        System.out.println(getInstant());
    }
}
