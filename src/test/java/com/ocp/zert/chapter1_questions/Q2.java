package com.ocp.zert.chapter1_questions;

public class Q2 {
    private int ISBN;
    private String title, author;
    private int pageCount;
    public int hashCode() {
        return ISBN;
    }
    @Override public boolean equals(Object obj) {
        if ( !(obj instanceof Q2)) {

            return false;
        }
        Q2 other = (Q2) obj;
        return this.ISBN == other.ISBN;
    }
    // imagine getters and setters are here
}