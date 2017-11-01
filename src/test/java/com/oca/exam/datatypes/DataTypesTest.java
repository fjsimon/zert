package com.oca.exam.datatypes;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DataTypesTest {

    @Test
    public void equalTest_Q67() {

        Integer i = new Integer(1) ;
        Long m = new Long(1);
        if( i.equals(m)) System.out.println("equal");   // 1
        else System.out.println("not equal");
    }

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

    @Test
    public void test04_Q33() {
        int rate = 10;
        int t = 5;
        double amount = 1000.0; // ? double or float
        for(int i=0; i<t; i++){
            amount = amount*(1 - rate/100);
        }
    }

    @Test
    public void test04_Q54() {

        new AccessTest();
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

    @Test
    public void test06_Q59() {
        assertThat(Boolean.parseBoolean(" true "), is(false));
        assertThat(Boolean.parseBoolean("true"), is(true));
        assertThat(Boolean.valueOf(true), is(true));
        assertThat(Boolean.valueOf("trUE"), is(true));
        assertThat(Boolean.TRUE, is(true));
    }
}

 class AccessTest{

    String a = "x";
    static char b = 'x';
    String  c = "x";
    class Inner {
        String  a = "y";
        String  get() {
            String c = "temp";
            // Line 1
//            c = ""+AccessTest.b;
//            c = AccessTest.this.a;
//            c = ""+b;

            return c;
        }
    }

    AccessTest() {
        System.out.println(  new Inner().get()  );
    }
}