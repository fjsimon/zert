package com.fjsimon.zert.inheritance;

public class MovableDonkeyTest {

    public static void main(String[] args) {
        Movable m = new Donkey();
        m.move(10);
        m.moveBack(20);
        System.out.println(m.getLocation());
        System.out.println(m.location);


    }
}