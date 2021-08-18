package com.fjsimon.zert.common;

public enum Species {
    HUMAN("human"),
    ROBOT("robot"),
    MUTANT("mutant");

    private final String title;

    Species(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
