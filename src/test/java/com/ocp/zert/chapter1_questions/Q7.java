package com.ocp.zert.chapter1_questions;

public class Q7 {
    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBERRY
    }
    public static void main(String[] args) {

        Flavors f = Flavors.STRAWBERRY;
        switch (f) {
//            case 0: System.out.println("vanilla");
//            case 1: System.out.println("chocolate");
//            case 2: System.out.println("strawberry");
//                break;
            default: System.out.println("missing flavor");
        }
    }
}