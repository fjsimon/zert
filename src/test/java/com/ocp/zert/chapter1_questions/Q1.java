package com.ocp.zert.chapter1_questions;

public class Q1 {
    public int employeeId;
    public String firstName, lastName;
    public int yearStarted;
    @Override public int hashCode() {
        return employeeId;
    }
    public boolean equals(Q1 e) {
        return this.employeeId == e.employeeId;
    }
    public static void main(String[] args) {
        Q1 one = new Q1();
        one.employeeId = 101;
        Q1 two = new Q1();
        two.employeeId = 101;
        if (one.equals(two)) System.out.println("Success");
        else System.out.println("Failure");
    } }