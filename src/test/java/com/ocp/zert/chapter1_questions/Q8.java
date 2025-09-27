package com.ocp.zert.chapter1_questions;

public class Q8 {

    private int x = 5;

    protected class Inner {

//        public static int x = 10;
        public void go() {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {

        Q8 out = new Q8();
        Q8.Inner in = out.new Inner();
        in.go();
    }
}