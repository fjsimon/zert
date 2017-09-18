package com.oca.exam.datatypes;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DataTypesTest {

    public static int getSwitch(String str) {
        int round = (int) Math.round(Double.parseDouble(str.substring(1, str.length() - 1)));
        System.out.printf("round %d %n", round);
        return round;
    }

    @Test
    public void test02_Q27() {

        String args = ".01";
        switch (getSwitch(args)) {
            case 0:
                System.out.print("Hello ");
            case 1:
                System.out.print("World");
                break;
            default:
                System.out.print("Good Bye");
        }
    }

    public static boolean method1(int i) {

        return i > 0 ? true : false;
    }

    @Test
    public void test02_Q47() {
        int i = 0;
        boolean bool1 = true;
        boolean bool2 = false;
        boolean bool = false;
        bool = (bool2 & method1(i++)); //1
        bool = (bool2 && method1(i++)); //2
        bool = (bool1 | method1(i++)); //3
        bool = (bool1 || method1(i++)); //4

        assertThat(i, is(2));
    }

    @Test
    public void test02_Q58() {
        int i = 0;
        loop :         // 1
        {
            System.out.println("Loop Label line");
            try{
                for (  ;  true ;  i++ ){
                    if( i >5) break loop;       // 2
                }
            } catch(Exception e){
                System.out.println("Exception in loop.");
            } finally{
                System.out.println("In Finally");      // 3
            }
        }
    }
}

class InitTest {
    static int si = 10;
    int i;
    final boolean bool;

//     instance { bool = true; }

//    InitTest() { si += 10; }

//    {
//        si = 5;
//        i = bool ? 1000 : 2000;
//    }

//    {
//        i = 1000;
//    }

    {
        bool = (si > 5);
        i = 1000;
    }
}