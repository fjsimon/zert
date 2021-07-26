package com.fjsimon.zert.operations;

public class ChangeTestQ29 {

    private int myValue = 0;

    public void showOne(int myValue) {
        myValue = myValue;
    }

    public void showTwo(int myValue) {
        this.myValue = myValue;
    }

    public static void main(String[] args) {

        ChangeTestQ29 ct = new ChangeTestQ29();
        ct.showOne(100);
        System.out.println(ct.myValue);
        ct.showTwo(200);
        System.out.println(ct.myValue);
    }
}