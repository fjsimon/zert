package com.fjsimon.zert.datatypes;

public class InitClass {

    private static int loop = 15 ;
    static final int INTERVAL = 10 ;
    boolean flag ;
    //line 1

    //Possible options:
    static {System.out.println("Static"); }
    static { loop = 1; System.out.println("loop = " + loop);}
    static { loop += INTERVAL; System.out.println("loop = " + loop);}
//    static { INTERVAL = 10; }
    { flag = true; loop = 0; System.out.println("loop = " + loop + ", flag = " + flag);}
}