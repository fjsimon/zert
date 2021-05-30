package com.fjsimon.zert.methods;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MethodTest {



    public static void processStacks(Stack x1, Stack x2) {

        x1.push(new Integer("100")); //assume that the method push adds the passed object to the stack.
        x2 = x1;
    }

    @Test
    public void test01_stack() {

        Stack s1 = new Stack();
        Stack s2 = new Stack();
        processStacks(s1, s2);
        System.out.println(s1 + "    " + s2);
    }

    class Base {
        public Object getValue() {
            return new Object();
        } //1
    }

    class Base2 extends Base {
        public String getValue() {
            return "hello";
        } //2
    }

    @Test
    public void test01_base() {

        Base b = new Base2();
        assertThat(b.getValue(), is("hello")); //3
    }

    void probe(Integer x) {
        System.out.println("In Integer");
    } //2

    void probe(Object x) {
        System.out.println("In Object");
    } //3

    void probe(Long x) {
        System.out.println("In Long");
    } //4

    @Test
    public void test01_Q18() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String a = "hello";
        probe(a);
        assertThat("In Object\n", is(outputStream.toString()));
    }

    @Test
    public void test02_Q23() {
        System.out.println(new MNOP().x + ", " + new MNOP().y);
    }

    @Test
    public void test02_Q30() {

        ClassQ30 a, b;
        a = new ClassQ30();  //(2)
        assertThat(a.l1, is(0L));
//        b = new ClassQ30(5);  //(3) Compilation error
    }

    class Super {
    }

    class Sub extends Super {
    }

    @Test
    public void test02_Q38() {
        Super s1 = new Super(); //1
        Sub s2 = new Sub();     //2
        s1 = (Super) s2;        //3
        assertThat(s1, instanceOf(Super.class));
        assertThat(s2, instanceOf(Super.class));
    }

    class A {
    }

    class AA extends A {
    }

    @Test
    public void test02_Q40() {
        A a = new A();
        AA aa = new AA();
        a = aa;
        assertThat(a.getClass().toString(), is("class com.fjsimon.zert.methods.MethodTest$AA"));
        assertThat(aa.getClass().toString(), is("class com.fjsimon.zert.methods.MethodTest$AA"));
    }

    class Base3 {
        public short getValue() {
            return 1;
        } //1
    }

    class Base4 extends Base3 {
//    public byte getValue(){ return 2; } //2 Compile error
    }

    @Test
    public void test02_Q45() {
        Base3 b = new Base4();
        assertThat(b.getValue(), is((short) 1)); //3
    }

}

class ABCD {
    int x = 10;
    static int y = 20;
}

class MNOP extends ABCD {
    int x = 30;
    static int y = 40;
}

class ClassQ30 {
    long l1;

    public void ClassQ30(long pLong) {
        l1 = pLong;
    }//(1)
}

class ClassQ46 {

    void m1() {
        ClassQ46.m2();  // 1
        m4();             // 2
//        ClassQ46.m3();  // 3 Compile error
    }

    static void m2() {
    }  // 4

    void m3() {
        m1();            // 5
        m2();            // 6
//        ClassQ46.m1(); // 7 Compile error
    }

    static void m4() {
    }
}