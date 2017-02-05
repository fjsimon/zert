package com.oca.exam.review;

public class BearOrShark {

    public static String getResult() {
        int luck = 10;
        String result = "";
        if((luck>10 ? luck++ : --luck) < 10){
            result += "Bear";
        }
        if(luck < 10){
            result += "Shark";
        }
        return result;
    }
}
