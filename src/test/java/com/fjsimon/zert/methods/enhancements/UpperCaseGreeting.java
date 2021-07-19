package com.fjsimon.zert.methods.enhancements;

// Inheritance rules when extending interfaces that contain default methods:

// 1) Not mention the default method at all, which lets your extended interface inherit the default method.
interface UpperCaseGreeting extends DefaultGreeting {

    String getGreetingInUpperCase(String name);
}

