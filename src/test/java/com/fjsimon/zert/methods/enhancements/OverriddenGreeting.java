package com.fjsimon.zert.methods.enhancements;

// Inheritance rules when extending interfaces that contain default methods:

// 3) Redefine the default method, which overrides it.
interface OverriddenGreeting extends DefaultGreeting {

    @Override
    default String getTemplate() {

        return "Overridden hello to you, %s!";
    }
}

