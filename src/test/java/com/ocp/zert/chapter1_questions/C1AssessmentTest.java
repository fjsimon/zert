package com.ocp.zert.chapter1_questions;

import com.ocp.zert.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BaseTest.class)
public class C1AssessmentTest {

    @Test
    public void q03() {

        String s1 = "Canada";
        String s2 = new String(s1);
        if(s1 == s2) System.out.println("s1 == s2");
        if(s1.equals(s2)) System.out.println("s1.equals(s2)");

    }
}





