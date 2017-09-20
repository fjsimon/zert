package com.oca.exam.inheritance;

import org.junit.Test;

class A{
    int max(int x, int y)  { if (x>y) return x; else return y; }
}
class B extends A{
    int max(int x, int y)  {  return 2 * super.max(x, y) ; }
}
class C extends B{
    int max(int x, int y)  {  return super.max( 2*x, 2*y); }
}

class TestClass{
    static int si = 10;
    public TestClass(){
        System.out.println(this);
    }
    public String toString(){
        return "TestClass.si = "+this.si;
    }
}


public class InheritanceTest {

    @Test
    public void test3Q01() {
        B c = new C();
        System.out.println(c.max(10, 20));
    }

    @Test
    public void test04_Q36() {

        new TestClass();
    }

    @Test
    public void test04_Q46() {

        AQ46 a = new BQ46();
        System.out.println(a.i);
        a.m1();
        a.m2();
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