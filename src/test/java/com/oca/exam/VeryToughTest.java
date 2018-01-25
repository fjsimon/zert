package com.oca.exam;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VeryToughTest {

    @Test
    public void q02() {

        Object t = new Integer(106);
        int k = ((Integer) t).intValue() / 10;
        System.out.println(k);
        System.out.println(100 / 9.9);
        System.out.println(100 / 10.0);
        System.out.println(100 / 10);
        System.out.println(3 + 100 / 10 * 2 - 13);
    }

    @Test
    public void q03() {
        ParentA a = new ChildA();
        a.print();
    }

    @Test
    public void q04() {
        String mStr = "123";

        long m1 = new Long(mStr);
        long m2 = Long.parseLong(mStr);
        long m3 = Long.valueOf(mStr).longValue();

        System.out.println(m1 + " " + m2 + " " + m3);
    }

    @Test
    public void q08() {
        Object t = new Integer(107);
        int k = (new Integer((int) t)).intValue() / 9;
        System.out.println(k);
    }

    @Test
    public void q09() {

        String fullPhoneNumber = "ddd-ddd-dddd";

        System.out.println(new StringBuilder(fullPhoneNumber).substring(0, 8) + "xxxx");
        System.out.println(new StringBuilder(fullPhoneNumber).replace(8, 12, "xxxx").toString());
//        System.out.println(new StringBuilder(fullPhoneNumber).append("xxxx", 8, 12).toString());
        System.out.println(new StringBuilder("xxxx").append(fullPhoneNumber, 0, 8).toString());
        System.out.println(new StringBuilder("xxxx").insert(0, fullPhoneNumber, 0, 8).toString());

    }

    @Test
    public void q11() {

        assertFalse("String".replace('g', 'G') == "String".replace('g', 'G'));
        assertFalse("String".replace('g', 'g') == new String("String").replace('g', 'g'));
        assertFalse("String".replace('g', 'G') == "StrinG");
        assertTrue("String".replace('g', 'g') == "String");
    }

    @Test
    public void q19() {

//        assertTrue(Boolean.parseBoolean(" true "));
        assertTrue(Boolean.parseBoolean("true"));
        assertTrue(Boolean.valueOf(true));
        assertTrue(Boolean.valueOf("trUE"));
        assertTrue(Boolean.TRUE);
    }
}


class ParentA {

    ParentA() {
        print();
    }

    void print() {
        System.out.println("A");
    }
}

class ChildA extends ParentA {
    int i = 4;

    void print() {
        System.out.println(i);
    }
}

class TestClassQ10 {

    public void method(Object o) {
        System.out.println("Object Version");
    }

    public void method(java.io.FileNotFoundException s) {
        System.out.println("java.io.FileNotFoundException Version");
    }

    public void method(java.io.IOException s) {
        System.out.println("IOException Version");
    }

    public static void main(String args[]) {
        TestClassQ10 tc = new TestClassQ10();
        tc.method(null);
    }
}

class TestQ16 {

    public static void testInts(Integer obj, int var) {
        obj = var++;
        obj++;
    }
    public static void main(String[] args) {
        Integer val1 = new Integer(5);
        int val2 = 9;
        testInts(val1++, ++val2);
        System.out.println(val1+" "+val2);
    }
}

class Baap {

    public int h = 4;
    public int getH() {
        System.out.println("Baap "+h); return h;
    }
}


class Beta extends Baap {

    public int h = 44;
    public int getH() {
        System.out.println("Beta "+h); return h;
    }
    public static void main(String[] args) {
        Baap b = new Beta();
        System.out.println(b.h+" "+b.getH());
        Beta bb = (Beta) b;
        System.out.println(bb.h+" "+bb.getH());
    }
}