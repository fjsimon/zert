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

public class InheritanceTest {

    @Test
    public void test3Q01() {
        B c = new C();
        System.out.println(c.max(10, 20));
    }
}



