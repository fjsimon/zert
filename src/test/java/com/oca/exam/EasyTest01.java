package com.oca.exam;

import org.junit.Test;

public class EasyTest01 {


    @Test(expected = NullPointerException.class)
    public void q04() {

        int ia[][] = { {1, 2}, null };
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                System.out.println(ia[i][j]);

    }

    @Test
    public void q07() {

        A b = new B("good bye");
    }

    @Test
    public void q09() {

        int sum = 0;
        for (int i = 0, j = 10; sum > 20; ++i, --j)      // 1
        {
            sum = sum + i + j;
        }
        System.out.println("Sum = " + sum);
    }

    @Test
    public void q10() {

        int i, j, k;
        i = j = k = 9;
        System.out.println(i);
    }
}


class A {
    A() {
        this("hello", " world");
    }

    A(String s) {
        System.out.println(s);
    }

    A(String s1, String s2) {
        this(s1 + s2);
    }
}

class B extends A {

    B() {
        super("good bye");
    };

    B(String s) {
        super(s, " world");
    }

    B(String s1, String s2) {
        this(s1 + s2 + " ! ");
    }
}