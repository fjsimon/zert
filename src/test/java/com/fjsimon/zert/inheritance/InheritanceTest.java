package com.fjsimon.zert.inheritance;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class InheritanceTest extends BaseTest {

    @Test
    public void test3Q01() {
        B c = new C();
        System.out.println(c.max(10, 20));
    }

    @Test
    public void parentChildTest() {

        Parent parent = new Child(5);
        assertThat(parent.hasHorns(), is(true));
    }

    @Test
    public void egretTest() {

        Egret e = new Egret();
        assertThat(e.color, is(nullValue()));
    }

    @Test
    public void inheritanceTest() {

        Baap b = new Beta();
        System.out.println(b.h + " " + b.getH());
        assertThat(b.h, is(4));
        assertThat(b.getH(), is(44));

        Beta bb = (Beta) b;
        System.out.println(bb.h + " " + bb.getH());
        assertThat(bb.h, is(44));
        assertThat(bb.getH(), is(44));
    }
}

class A {
    int max(int x, int y)  { if (x>y) return x; else return y; }
}
class B extends A {
    int max(int x, int y)  {  return 2 * super.max(x, y) ; }
}
class C extends B {
    int max(int x, int y)  {  return super.max( 2*x, 2*y); }
}

//interface Account{
//    public default String getId(){
//        return "0000";
//    }
//}
//interface PremiumAccount extends Account{
//    public String getId();
//}
//public class BankAccount implements PremiumAccount{
//    public static void main(String[] args) {
//        Account acct = new BankAccount();
//        System.out.println(acct.getId());
//    }
//}

class ClassA_Q55 {

    int i;

    public ClassA_Q55(int x) {

        this.i = x;
    }
}

class ClassBQ55 extends ClassA_Q55 {
    int j;

//    ClassBQ55( ) { }

//    ClassBQ55(int y ) { j = y; }

//    ClassBQ55(int y) {
//        super(y * 2);
//        j = y;
//    }

//    ClassBQ55(int y ) { i = y; j = y*2; }

    ClassBQ55(int z) {
        this(z, z);
    }

    ClassBQ55(int x, int y) {

        super(x);
        this.j = y;
    }
}

class CorbaComponent{
    String ior;
    CorbaComponent(){ startUp("IOR"); }
    void startUp(String s){ ior  =  s; }
    void print(){ System.out.println(ior); }
}

class OrderManager extends CorbaComponent{
    OrderManager(){  }
    void startUp(String s){  ior = getIORFromURL(s);   }
    String getIORFromURL(String s){  return "URL://"+s; }
}

class Application{
    public static void main(String args[]){ start(new OrderManager()); }
    static void start(CorbaComponent cc){ cc.print(); }
}

class MyCarStation{


    public static void main(String... args){

        FourWheel fourWheel = new FourWheel();
        Car car = fourWheel;

        System.out.println(fourWheel.getSize());
        System.out.println(car.getSize());

        System.out.println(getInfo(fourWheel));
        System.out.println(getInfo(car));

        System.out.println(fourWheel.getPrice());
        System.out.println(car.getPrice());

        System.out.println(FourWheel.getSize());
        System.out.println(Car.getSize());
    }

    private static String getInfo(FourWheel fourWheel){

        return "fourWheel";
    }

    private static String getInfo(Car car){

        return "car";
    }
}

class Car {

    public static String getSize(){
        return "small";
    }

    public int getPrice(){
        return 100;
    }

}

class FourWheel extends Car {

    public static String getSize(){
        return "big";
    }

    public int getPrice(){
        return 200;
    }
}


class Parent {

    public Parent() { System.out.print("Parent"); }

    public Parent(int age) { System.out.print("ParentAge"); }

    public boolean hasHorns() { return false; }

}

class Child extends Parent {

    public Child(int age) { System.out.print("Child"); }

    public boolean hasHorns() { return true; }
}

class Egret {

    public String color;

    public Egret(){
        this("White");
    }

    private Egret(String color){
        color = color;
    }
}

interface CanSwim { }

class Amphibian implements CanSwim { }

class Tadpole extends Amphibian { }

class FindAllTadpole {
    public static void main(String[] args) {
        List<Tadpole> tadpoleList = new ArrayList<>();
        Tadpole tadpole = new Tadpole();
        tadpoleList.add(tadpole);

        for (Amphibian amphibian : tadpoleList) {
            CanSwim tadpole1 = amphibian;
            Amphibian tadpole2 = amphibian;
            Object tadpole3 = amphibian;
        }
    }
}

class Teacher{
    void teach(String student){
        /* lots of code */
    }
}
class Professor extends Teacher {

//    public void teach() throws Exception {}
//    private void teach(int i) throws Exception {}
//    protected void teach(String s) {}
//    public final void teach(String s) {}
//    public abstract void teach(String s); // Fails

}