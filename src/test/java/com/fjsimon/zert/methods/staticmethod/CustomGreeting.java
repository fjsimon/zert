package com.fjsimon.zert.methods.staticmethod;

import static java.lang.String.format;

class CustomGreeting implements Greeting {

    private String name;

    @Override
    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String getGreeting() {

        return format(Greeting.getTemplate(), name);
    }
}