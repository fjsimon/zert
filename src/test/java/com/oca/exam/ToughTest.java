package com.oca.exam;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class ToughTest {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @After
    public void after() {
        System.out.printf("End %s %n%n", name.getMethodName());
    }

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
        int var = 20, i = 0;
        do {
            while (true) {
                if (i++ > var) break;
                System.out.printf("i = %s, var = %s%n", i, var);
            }
            System.out.printf("i = %s, var = %s%n", i, var);
        } while (i < var--);

        System.out.println(var);
    }

    static void start(CorbaComponent cc) {
        cc.print();
    }

    @Test
    public void q11() {

        start(new OrderManager());
    }

    @Test()
    public void q16() {

        int i = 0 ;
        int[] iA = {10, 20} ;
        iA[i] = i = 30 ;
        System.out.println(""+ iA[ 0 ] + " " + iA[ 1 ] + "  "+i) ;
    }

}

class CorbaComponent {
    String ior;

    CorbaComponent() {
        System.out.println("CorbaComponent constructor");
        startUp("IOR");
    }

    void startUp(String s) {
        System.out.println("CorbaComponent startUp");
        ior = s;
    }

    void print() {
        System.out.println(ior);
    }
}

class OrderManager extends CorbaComponent {
    OrderManager() {

        System.out.println("OrderManager constructor");
    }

    void startUp(String s) {

        System.out.println("OrderManager startUp");
        ior = getIORFromURL(s);
    }

    String getIORFromURL(String s) {

        return "URL://" + s;
    }
}