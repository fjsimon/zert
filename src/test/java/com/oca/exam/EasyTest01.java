package com.oca.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EasyTest01 {


    @Test(expected = NullPointerException.class)
    public void q04() {

        int ia[][] = {{1, 2}, null};
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

    @Test
    public void q14() {

        Object o1 = new Object();
        Object o2 = new Object();

        String a = new String("string");
        String b = new String("string");

        assertThat(o1.equals(o2), is(false));
        assertThat(o1.hashCode() == o2.hashCode(), is(false));
        assertThat(o1 == o2, is(false));

        assertThat(a.equals(b), is(true));
        assertThat(a.hashCode() == b.hashCode(), is(true));
        assertThat(a == b, is(false));
    }

    public static boolean method1(String str) {

        System.out.println(str);
        return true;
    }

    @Test
    public void q19() {

        int i = 0;
        boolean bool1 = true;
        boolean bool2 = false;
        boolean bool = false;
        bool = (bool2 & method1("1"));  //1 call method1
        bool = (bool2 && method1("2"));  //2
        bool = (bool1 | method1("3"));  //3 call method1
        bool = (bool1 || method1("4"));  //4
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