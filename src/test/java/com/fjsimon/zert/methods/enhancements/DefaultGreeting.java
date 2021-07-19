package com.fjsimon.zert.methods.enhancements;

interface DefaultGreeting {

    String getGreeting(String name);

    // default method in question
    default String getTemplate() {

        return "Hello, %s!";
    }
}