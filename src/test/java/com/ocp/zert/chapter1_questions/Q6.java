package com.ocp.zert.chapter1_questions;

public class Q6 {
    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBERRY
    }
    public static void main(String[] args) {
        System.out.println(Flavors.CHOCOLATE.ordinal());
    }
}