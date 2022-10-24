package com.fjsimon.zert.inheritance;

public interface Movable {
    int location = 0;
    void move(int by);
    public void moveBack(int by);

    public int getLocation();
}