package com.fjsimon.zert.review;

public class Egret {

    private String color;
    public Egret(){
        this("White");
    }

    private Egret(String color){
        color = color;
    }

    public static void main(String[] args){
        Egret e = new Egret();
        System.out.println("Color:" + e.color);
    }
}
