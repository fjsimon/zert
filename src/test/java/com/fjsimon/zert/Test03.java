package com.fjsimon.zert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Test03 {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void q12() {

        int INT1 = 0;
        int INT2 = 5;

        for (int i = INT1; i < INT2; i++) {
            System.out.printf("%s \t", i); // 0 1 2 3 4
        }
        System.out.println();

        for (int i = INT1; i < INT2; System.out.printf("%s \t", ++i)); // 1, 2, 3, 4, 5
        System.out.println();

        for (int i = INT1; i++ < INT2; System.out.printf("%s \t", i)) ; // 1, 2, 3, 4, 5
        System.out.println();

        int i = INT1;
        while (i++ < INT2) {
            System.out.printf("%s \t", i); // 1, 2, 3, 4, 5
        }
        System.out.println();

        i = INT1;
        do {
            System.out.printf("%s \t", i); // 0, 1, 2, 3, 4, 5
        } while (i++ < INT2);
        System.out.println();
    }

    class Game {
        public void play() throws Exception {

            System.out.println("Playing...");
        }
    }

    class Soccer extends Game {
        public void play(String ball) {
            System.out.println("Playing Soccer with " + ball);
        }
    }

    @Test
    public void q13() throws Exception {
        Game g = new Soccer();
        g.play();
        Soccer s = (Soccer) g;
        s.play();
    }

    public static int operators() {

        int x1 = -4;
        // x2 is (x1)-- => x2 is first assigned the value of x1 i.e. -4 and then x1 in decremented by 1 to become -5
        int x2 = x1--;
        // x3  is ++(x2) => x2 becomes -3 first and  then its value i.e. -3 is assigned to x3
        int x3 = ++x2;
        // x2>x3 is false so x1++  => x1 becomes -4
        if (x2 > x3) {
            --x3;
        } else {
            x1++;
        }
        //therefore -4 + -3 + -3 => -10
        return x1 + x2 + x3;
    }

    @Test
    public void q16() {

        assertThat(operators(), is(-10));
    }

    @Test
    public void q17() {

        ArrayList<Double> al = new ArrayList<>();
//        al.add(111); //Compile error
        System.out.println(al.indexOf(1.0));
        System.out.println(al.contains("string"));
//        Double d = al.get(al.length); //Compile error

    }

    @Test
    public void q20() {

        String String = "string isa string";
        System.out.println(String.substring(3, 6));
//        assertThat(String.format("%s%n", "ing"), CoreMatchers.is(outputStream.toString()));
    }

    @Test(expected = NullPointerException.class)
    public void q27() {

        final Holder a = new Holder(5);
        Holder b = new Holder(10);
        a.link = b;
        b.link = Holder.setIt(a, b);
        System.out.println(a.link.value + " " + b.link.value);
    }

    @Test
    public void q31() {
        int i = 0;
        int j = 1;
        if ((i++ == 0) & (j++ == 2)) {
            i = 12;
        }
        System.out.println(i + " " + j);
    }

    @Test
    public void q33() {

        int rate = 10;
        int t = 5;
        double amount = 1000.0; // ? double or float
        for (int i = 0; i < t; i++) {
            amount = amount * (1 - rate / 100);
        }
    }

    @Test
    public void q36() {

        new TestClass();
    }

    static int val() throws Exception {
        throw new Exception("unimplemented");
    }

    @Test
    public void q37() {

        int[][] a = {{00, 01}, {10, 11}};
        int i = 99;
        try {
            a[val()][i = 1]++;
        } catch (Exception e) {
            System.out.println(i + ", " + a[1][1]);
        }
    }

    @Test
    public void q39() {

        InitTest it = new InitTest();
    }

    @Test
    public void q44() {

        System.out.println(1 + 2 + "3");
        System.out.println("1" + 2 + 3);
        System.out.println(4 + 1.0f);
        System.out.println(5 / 4);
        System.out.println('a' + 1);
    }

    @Test
    public void q46() {

        AQ46 a = new BQ46();
        System.out.println(a.i);
        a.m1();
        a.m2();
    }

    @Test
    public void q52() {

        int i = 1;
        int j = i++;
        if ((i == ++j) | (i++ == j)) {
            i += j;
        }
        System.out.println(i);
    }

    @Test
    public void q54() {

        new AccessTest();
    }

    static void replaceString(String s) {

        s = s.replace('j', 'l');
    }

    static void replaceStringBuilder(StringBuilder s) {

        s.append("c");
    }

    private void finallyMethod(String[] args) {
        try {
            if (args.length == 0) return;
            else throw new Exception("Some Exception");
        } catch (Exception e) {
            System.out.println("Exception in Main");
        } finally {
            System.out.println("The end");
        }
    }

    @Test
    public void q60() {

        String[] args = {};
        finallyMethod(args);
//        assertThat(String.format("%s%n", "The end"), is(outputStream.toString()));
//        outputStream.reset();

        String[] withArgs = {"args"};
        finallyMethod(withArgs);
//        assertThat(String.format("%s%n%s%n", "Exception in Main", "The end"), is(outputStream.toString()));
    }

    @Test
    public void q64() {
        int k = 1;
        int[] a = {1};
        k += (k = 4) * (k + 2);
        a[0] += (a[0] = 4) * (a[0] + 2);
        System.out.println(k + " , " + a[0]);
    }

    @Test
    public void q65() {
        int i = 0, j = 5;
        lab1:
        for (; ; i++) {
            for (; ; --j)
                if (i > j)
                    break lab1;
        }
        System.out.println(" i = " + i + ", j = " + j);
    }

    @Test
    public void q68() {

        String s1 = new String("java");
        StringBuilder s2 = new StringBuilder("java");
        replaceString(s1);
        replaceStringBuilder(s2);
        System.out.println(s1 + s2);
//        assertThat(String.format("%s%n", "javajavac"),
//                CoreMatchers.is(outputStream.toString()));
    }

}

class AQ46 {

    int i = 10;

    public static void m1() {

        System.out.println("A m1");
    }

    public void m2() {

        System.out.println("A m2");
    }
}

class BQ46 extends AQ46 {

    int i = 20;

    public static void m1() {

        System.out.println("B m1");
    }

    public void m2() {

        System.out.println("B m2");
    }
}

class TestClass {

    static int si = 10;

    public TestClass() {

        System.out.println(this);
    }

    public String toString() {

        return "TestClass.si = " + this.si;
    }
}

class AccessTest {

    String a = "x";
    static char b = 'x';
    String c = "x";

    class Inner {
        String a = "y";

        String get() {
            String c = "temp";
            // Line 1
//            c = ""+AccessTest.b;
//            c = AccessTest.this.a;
//            c = ""+b;
            return c;
        }
    }

    AccessTest() {

        System.out.println(new Inner().get());
    }
}

class Holder {
    int value = 1;
    Holder link;

    public Holder(int val) {

        this.value = val;
    }

    public static Holder setIt(final Holder x, final Holder y) {

        x.link = y.link;
        return x;
    }
}

class InitTest {
    static String s1 = sM1("a");

    {
        s1 = sM1("b");
    }

    static {
        s1 = sM1("c");
    }

    private static String sM1(String s) {
        System.out.println(s);
        return s;
    }
}
class LoopTest{
    public static void main(String args[]) {
        int counter = 0;
        outer:
        for (int i = 0; i < 3; i++) {
            middle:
            for (int j = 0; j < 3; j++) {
                inner:
                for (int k = 0; k < 3; k++) {
                    if (k - j > 0) {
                        System.out.printf("i %s j %s k %s%n", i, j, k);
                        break middle;
                    }
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}

class TestClassQ29{
    void probe(int... x) { System.out.println("In ..."); }  //1

    void probe(Integer x) { System.out.println("In Integer"); } //2

    void probe(long x) { System.out.println("In long"); } //3

    void probe(Long x) { System.out.println("In LONG"); } //4

    public static void main(String[] args){
        Integer a = 4; new TestClassQ29().probe(a); //5
        int b = 4; new TestClassQ29().probe(b); //6
    }
}