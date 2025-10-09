package com.ocp.zert.chapter1_questions;

public class Q9 {
    private int x = 24;
    public int getX() {
        String message = "x is ";

        class Inner {
            private int x = Q9.this.x;
            public void printX() {
                System.out.println(message + x);
            }
        }
        Inner in = new Inner();
        in.printX();
        return x;
    }


    public static void main(String[] args) {
        new Q9().getX();
    }
}