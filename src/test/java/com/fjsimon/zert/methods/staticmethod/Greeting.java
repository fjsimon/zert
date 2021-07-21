package com.fjsimon.zert.methods.staticmethod;

interface Greeting {

    void setName(String name);

    String getGreeting();

    // static method in question
    static String getTemplate() {

        return "Hello, %s!";
    }
}