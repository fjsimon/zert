package com.oca.exam;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EasyTest01 {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void q02() {

        String string = new String("123456789");
        string.charAt('1');

        char ch = "12345".charAt(3);
        System.out.println(ch);
    }

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

    @Test
    public void q23() {

        StringBuilder sb = new StringBuilder("12345678");
        sb.setLength(5);
        sb.setLength(10);
        System.out.println(sb.length());
    }

    @Test
    public void q25() {

        int i;
        int j;
        for (i = 0, j = 0; j < i; ++j, i++){
            System.out.println(i + " " + j);
        }
        System.out.println(i + " " + j);
    }

    @Test
    public void q27() {

        String s = "blooper";
        StringBuilder sb = new StringBuilder(s);
//        s.append("whopper"); // It will not compile
        sb.append("shopper");

        System.out.println(s);
        System.out.println(sb);
    }

    public static void printSum(double a, double b){
        System.out.println("In double "+(a+b));
    }
    public static void printSum(float a, float b){
        System.out.println("In float "+(a+b));
    }

    @Test
    public void q30() {

        printSum(1.0, 2.0);
        printSum(1,2);
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