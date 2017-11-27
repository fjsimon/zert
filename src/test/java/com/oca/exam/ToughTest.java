package com.oca.exam;

import org.junit.Test;

public class ToughTest {

    @Test
    public void q01() {

        int i = 4;
        int ia[][][] = new int[i][i = 3][i];
        System.out.println(ia.length + ", " + ia[0].length + ", " + ia[0][0].length);
    }

    public float parseFloat(String s) {
        float f = 0.0f;      // 1
        try {
            f = Float.valueOf(s).floatValue();    // 2
            return f;      // 3
        } catch (NumberFormatException nfe) {
            f = Float.NaN;    // 4
            return f;     // 5
        } finally {
            return f;     // 6
        }
//        return f ;    // 7

        // line 7
        // line 3, 6
        // line 5, 6
        // line 3, 7
    }

    public static String getMsg(char x) {

        String msg = "Input value must be ";
        msg = msg.concat("smaller than X");
        msg.replace('X', x);
        String rest = " and larger than 0";
        msg.concat(rest);
        return msg;
    }

    @Test
    public void q05() {

        System.out.println(getMsg((char) 169));
    }

    @Test
    public void q06() {
        int var = 20, i=0;
        do{
            while(true){
                if( i++ > var) break;
                System.out.printf("i = %s, var = %s%n", i, var);
            }
            System.out.printf("i = %s, var = %s%n", i, var);
        }while(i<var--);

        System.out.println(var);
    }

}