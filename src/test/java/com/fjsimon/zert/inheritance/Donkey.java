package com.fjsimon.zert.inheritance;

public class Donkey implements Movable{
    int location = 200;
    public void move(int by) {
        location = location+by;
    }
    public void moveBack(int by) {
        location = location-by;
    }

    public int getLocation() {
        return location;
    }
}