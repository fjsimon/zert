package com.fjsimon.zert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UniqueTest02 extends BaseTest {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void q1() {

        int k = 0;
        try{
            int i = 5/k;
        }
        catch (ArithmeticException e){
            System.out.println("1");
        }
        catch (RuntimeException e){
            System.out.println("2");
            return ;
        }
        catch (Exception e){
            System.out.println("3");
        }
        finally{
            System.out.println("4");
        }
        System.out.println("5");
    }

    @Test
    public void q2() {

        ArrayList<Vehicle> al1 = new ArrayList<>();
        al1.add(new SUV());
        ArrayList<Drivable> al2 = new ArrayList<>();
        al2.add(new Car2());
        ArrayList<Drivable> al3 = new ArrayList<>();
        al3.add(new SUV());
//        ArrayList<SUV> al4 = new ArrayList<>();
//        al4.add(new Car2());
        ArrayList<Vehicle> al5 = new ArrayList<>();
        al5.add(new Car2());
    }

    @Test
    public void q5() {

        byte b = -128 ;
        int i = b ;
        b = (byte) i ;
        System.out.println(i+" "+b);
    }

    @Test
    public void q11() {

        Integer i = new Integer(1) ;
        Long m = new Long(1);
        if( i.equals(m))
            System.out.println("equal");   // 1
        else
            System.out.println("not equal");

        LocalDateTime dt = LocalDateTime.parse("2015-01-02T17:13:50");
        System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(dt.toString());

    }

    @Test
    public void q34() {

        Integer i = Integer.parseInt("127");
        Integer j = i;
        i--;
        i++;
        System.out.println((i==j));
    }

    @Test
    public void q43() {

        Integer i1 = 1;
        Integer i2 = new Integer(1);
        int i3 = 1;
        Byte b1 = 1;
        Long g1 = 1L;

        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
//        System.out.println(i1 == b1);
        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(g1));
        System.out.println(i1.equals(b1));
    }

    @Test
    public void q56() {

//        float f1 = 1.0;
//        float f = 43e1;
        float f1 = -1;
        float f2 = 0x0123;
        float f3 = 4;

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
    }
}

abstract class Vehicle{ }
interface Drivable{ }
class Car2 extends Vehicle implements Drivable{ }
class SUV extends Car2 { }
