package com.oca.exam;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class Test05 {

    class A { }
    class B extends A { }

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void test06_Q05() {

        Object a, b, c ;
        a = new String("A");
        b = new String("B");
        c = a;
        a = b;
        System.out.println(""+c);
    }

    public static int m1(int i){
        return ++i;
    }

    @Test
    public void test06_Q08() {

        int k = m1(0);
        k += 3 + ++k;
        System.out.println(k);
    }

    @Test
    public void test06_Q24() {

        assertThat("String".replace('g', 'G') == "String".replace('g', 'G'),
                is(false));

        assertThat("String".replace('g', 'g') ==
                new String("String").replace('g', 'g'), is(false));

        assertThat("String".replace('g', 'G') == "StrinG", is(false));
        assertThat("String".replace('g', 'g') == "String", is(true));
    }

    @Test
    public void test06_Q26() {
        byte b = 1;
        char c = 1;
        short s = 1;
        int i = 1;

//        s = b * b ; // No compile
        i = b + b;
        s *= b;
//        c = c + b ; // No compile
        s += i;

        assertThat(i, is(2));
        assertThat(s, is((short) 3));
    }

    @Test()
    public void test06_Q27() {
        A[] a, a1;
        B[] b;
        a = new A[10]; a1  = a;
        b =  new B[20];
        a = b;  // 1
        b = (B[]) a;  // 2
        try {
            b = (B[]) a1; // 3
            fail();
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test06_Q32() {
        int i = 5;

        switch (i) {
            default:
            case 1:
                System.out.println(1);
            case 0:
                System.out.println(0);
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
        }
    }

    @Test
    public void test06_Q33() {

        int x = 0;
        labelA:
        for (int i = 10; i < 0; i--) { // <==== CHECK
            int j = 0;
            labelB:
            while (j < 10) {
                if (j > i)
                    break labelB;
                if (i == j) {
                    x++;
                    continue labelA;
                }
                j++;
            }
            x--;
        }
        System.out.println(x);
    }

    @Test
    public void test06_Q37() {

        InitClassQ37 obj = new InitClassQ37(5);
    }

    @Test
    public void test06_Q38() {
        int i = 5;
        float f = 5.5f;
        double d = 3.8;
        char c = 'a';

        if (i == f) {
            c++;
        }

        if (((int) (f + d)) == ((int) f + (int) d)) {
            c += 2;
        }
        System.out.println(c);
    }

    @Test
    public void test06_Q41() {

        int c = 0;
        A:
        for (int i = 0; i < 2; i++) {
            B:
            for (int j = 0; j < 2; j++) {
                C:
                for (int k = 0; k < 3; k++) {
                    c++;
                    System.out.printf("%d %d %d %n", i, j, k);
                    if (k > j) break;

                }
            }
        }
        System.out.println(c);
    }

    @Test
    public void test06_Q45() {

        boolean flag = false;

        if (flag)   //1
            if (flag)   //2
                System.out.println("True False");
            else        // 3
                System.out.println("True True");
        else        // 4
            System.out.println("False False");
    }

    @Test
    public void test06_Q46() {
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0 ; i < size ; ++i) System.out.println(arr[i]);
    }

    @Test
    public void test06_Q47() {

        byte b = 0;
        b--;
        System.out.println(b);
    }

    @Test
    public void test06_Q50() {

        int count = 0, sum = 0;

        do {
            if (count % 3 == 0) continue;
            System.out.printf("sum %d count %d %n", sum , count);
            sum += count;
        } while (count++ < 11);
        System.out.println(sum);
    }

    @Test
    public void test06_Q64() {

        int x = 1____3;   //1
        long y = 1_3;     //2
        float z = 3.234_567f; //3
        System.out.println(x+" "+y+" "+z);
    }
    @Test
    public void test06_Q66() {

        String fullPhoneNumber = "ddd-ddd-dddd";

        assertThat(new StringBuilder(fullPhoneNumber).substring(0, 8)+"xxxx",
                is("ddd-ddd-xxxx"));
        assertThat(new StringBuilder(fullPhoneNumber).replace(8, 12, "xxxx").toString(),
                is("ddd-ddd-xxxx"));
//        assertThat(new StringBuilder(fullPhoneNumber).append("xxxx", 8, 12).toString(),
//                is("ddd-ddd-xxxx"));
        assertThat(new StringBuilder("xxxx").append(fullPhoneNumber, 0, 8).toString(),
                is("xxxxddd-ddd-"));
        assertThat(new StringBuilder("xxxx").insert(0, fullPhoneNumber, 0, 8).toString(),
                is("ddd-ddd-xxxx"));
    }

    @Test
    public void test06_Q70() {

        TestClassQ70 tc = new TestClassQ70();
        tc.method(null);
    }
}

class InitClassQ37 {

    int m;
    static int i1 = 5;
    static int i2;
    int j = 100;
    int x;

    public InitClassQ37(int m) {
        System.out.println(i1 + "  " + i2 + "   " + x + "  " + j + "  " + m);
    }

    {
        j = 30;
        i2 = 40;
    }  // Instance Initializer

    static {
        i1++;
    }      // Static Initializer
}

class TestClassQ70{

    public void method(Object o) {

        System.out.println("Object Version");
    }

    public void method(java.io.FileNotFoundException s) {

        System.out.println("java.io.FileNotFoundException Version");
    }

    public void method(java.io.IOException s) {

        System.out.println("IOException Version");
    }
}