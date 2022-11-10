package com.fjsimon.zert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Test08 extends BaseTest {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void q8() {
        int x = 1____3;   //1

        long y = 1_3;     //2

        float z = 3.234_567f; //3

        System.out.println(x+" "+y+" "+z);
    }

    @Test
    public void q10() {

        String fullPhoneNumber = "ddd-ddd-dddd";

        assertThat(new StringBuilder(fullPhoneNumber).substring(0, 8)+"xxxx", is("ddd-ddd-xxxx"));
        assertThat(new StringBuilder(fullPhoneNumber).replace(8, 12, "xxxx").toString(), is("ddd-ddd-xxxx"));
//        assertThat(new StringBuilder(fullPhoneNumber).append("xxxx", 8, 12).toString(), is("ddd-ddd-xxxx"));
        assertThat(new StringBuilder("xxxx").append(fullPhoneNumber, 0, 8).toString(), is("xxxxddd-ddd-"));
        assertThat(new StringBuilder("xxxx").insert(0, fullPhoneNumber, 0, 8).toString(), is("ddd-ddd-xxxx"));
    }

    @Test
    public void q12() {
        int a = 10;
        int b = 20;
        a += (a = 4);
        b = b + (b = 5);
        System.out.println(a+ ",  "+b);
        assertThat(a, is(14));
        assertThat(b, is(25));
    }

    @Test(expected = NullPointerException.class)
    public void q15() {

        int ia[][] = { {1, 2}, null };
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                System.out.println(ia[i][j]);

    }

    @Test
    public void q18() {

        String[] args = {"hola"};

        if (args.length != 0)
            System.out.println(args[args.length-1]);

        int i = args.length;
        if (i != 0)
            System.out.println(args[i-1]);

        try {
            System.out.println(args[args.length - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {}

//        int i = args.length-1;
//        if (i > 0) System.out.println(args[i]);

//        try { System.out.println(args[args.length-1]); }
//        catch (NullPointerException e) {}
    }

    @Test
    public void q19() {

        assertThat(" hello world".trim(),
                is("hello world"));
        assertThat("hello".concat(" world"),
                is("hello world"));
        assertThat(new StringBuilder("world").insert(0, "hello ").toString(),
                is("hello world"));

        assertThat(("hello" + new String("world")),
                is("helloworld"));
        assertThat(new StringBuilder("world").append("hello ", 0 , 6).toString(),
                is("worldhello "));
    }

    @Test
    public void q22(){

        LocalDateTime greatDay = LocalDateTime.parse("2015-01-01T12:30");//2
        String greatDayStr = greatDay.format(DateTimeFormatter.ISO_DATE_TIME); //3
        System.out.println("Date with Time: " + greatDayStr);//4

        String str = "1982-10-09 01:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        System.out.println("Date with Time: " + dateTime);

        String strDate = "2015-08-04";
        LocalDate aLD = LocalDate.parse(strDate);
        System.out.println("Date: " + aLD);

        String strDatewithTime = "2015-08-04T10:11:30";
        LocalDateTime aLDT = LocalDateTime.parse(strDatewithTime);
        System.out.println("Date with Time: " + aLDT);

    }

    @Test
    public void q36() {

        int k = 1;
        int[] a = { 1 };
        k += (k = 4) * (k + 2);
        a[0] += (a[0] = 4) * (a[0] + 2);
        System.out.println( k + " , " + a[0]);
    }

    @Test
    public void q37() {

        int i = 0, j = 5;
        lab1 : for( ; ; i++) {
            for( ; ; --j)
                if( i >j )
                    break lab1;
        }
        System.out.println(" i = "+i+", j = "+j);
    }


    @Test
    public void q44() {
        int i = 0;
        loop :         // 1
        {
            System.out.println("Loop Lable line");
            try{
                for (  ;  true ;  i++ ){
                    if( i >5) break loop;       // 2
                }
            }
            catch(Exception e){
                System.out.println("Exception in loop.");
            }
            finally{
                System.out.println("In Finally");      // 3
            }
        }
    }

}

class Car{
    public int gearRatio = 8;
    public String accelerate() {  return "AC";  }
}

class SportsCar extends Car{
    public int gearRatio = 9;
    public String accelerate() {  return  "ASC";  }
    public static void main(String[] args){
        Car c = new SportsCar();
        Car b = new Car();
        SportsCar d = new SportsCar();
        System.out.println( c.gearRatio+"  "+c.accelerate() );
        System.out.println( d.gearRatio+"  "+d.accelerate() );
        System.out.println( b.gearRatio+"  "+b.accelerate() );

    }
}

class TestClassQ14{
    public void method(Object o){
        System.out.println("Object Version");
    }
    public void method(java.io.FileNotFoundException s){
        System.out.println("java.io.FileNotFoundException Version");
    }
    public void method(java.io.IOException s){
        System.out.println("IOException Version");
    }
    public static void main(String args[]){
        TestClassQ14 tc = new TestClassQ14();
        tc.method(null);
    }
}

class ScopeTest{
    static int x = 5;
    public static void main(String[] args){
        int x  = ( x=3 ) * 4;  // 1
        System.out.println(x);

    }
}

class E1 extends Exception{ }
class E2 extends E1 { }
class TestQ20{
    public static void main(String[] args){
        try{
            throw new E2();
        }
        catch(E1 e){
            System.out.println("E1");
        }
        catch(Exception e){
            System.out.println("E");
        }
        finally{
            System.out.println("Finally");
        }
    }
}

 class FinallyTest{
    public static void main(String args[]){
        try{
            if (args.length == 0) return;
            else throw new Exception("Some Exception");
        }
        catch(Exception e){
            System.out.println("Exception in Main");
        }
        finally{
            System.out.println("The end");
        }
    }
}

class SuperClass{
    static{ System.out.print("super "); }
}
class One{
    static {  System.out.print("one "); }
}
class Two extends SuperClass{
    static {  System.out.print("two "); }
}
class TestQ45{

    public static void main(String[] args){
        One o = null;
        Two t = new Two();System.out.println("12345".charAt(6));
    }
}