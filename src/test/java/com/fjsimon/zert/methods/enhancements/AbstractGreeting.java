package com.fjsimon.zert.methods.enhancements;

// Inheritance rules when extending interfaces that contain default methods:

// 2) Redeclare the default method, which makes it abstract.
interface AbstractGreeting extends DefaultGreeting {

    String getTemplate();
}
