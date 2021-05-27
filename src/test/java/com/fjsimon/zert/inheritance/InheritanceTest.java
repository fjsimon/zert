package com.fjsimon.zert.inheritance;

import org.junit.Test;

public class InheritanceTest {

    @Test
    public void test3Q01() {
        B c = new C();
        System.out.println(c.max(10, 20));
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