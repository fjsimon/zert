package com.fjsimon.zert.review;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BearOrSharkTest extends BaseTest {

    @Test
    public void test(){

        assertThat(checkBearShark(), is("BearShark"));
    }

    private static String checkBearShark() {
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