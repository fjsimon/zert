package com.oca.exam;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Test06 {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    public LocalDate process(LocalDate ld) {

        LocalDate ld2 = ld.plus(Period.of(0, 1, 1));
        return ld2;
    }

    @Test
    public void q04() {
        LocalDate now = LocalDate.now();
        assertThat(process(now).getMonthValue(), is(now.getMonthValue() + 1));
        assertThat(process(now).getDayOfMonth(), is(now.getDayOfMonth() + 1));
    }

    public void loopTest(int x) {
        loop:
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                System.out.println(i);
                if (x == 0) {
                    continue loop;
                }
                System.out.println(j);
            }
        }
    }

    @Test
    public void q07() {

        loopTest(0);
    }

    @Test
    public void q10() {

        assertThat(TestClassQ10.method(), is("Hello World"));
    }

    @Test
    public void q11() {

        boolean b1 = false;
        boolean b2  = false;
        if (b2 = b1 != b2) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    @Test(expected = ExceptionInInitializerError.class)
    public void q16() {

        AX ax = new AX();
    }

    @Test
    public void q23() {

        char c = 320;
        float f = 320;
        double d = 320;
        //byte b = 320;
        float v = 22.0f/7.0f;
    }

    @Test
    public void q24(){

        java.time.LocalDate dt = java.time.LocalDate.parse("2015-01-01").minusMonths(1).minusDays(1).plusYears(1);
        System.out.println(dt);
    }

    void crazyLoop(){
        int c = 0;
        JACK: while (c < 8){
            JILL: System.out.println(c);
            if (c > 3) break JACK; else c++;
        }
    }

    @Test
    public void q25() {

        crazyLoop();
    }

    @Test
    public void q27() {

        String[] args = {};
        Truck.main(args);
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void q28() {

        System.out.println(LocalDate.of(2015, Month.JANUARY, 01)
                .format(DateTimeFormatter.ISO_DATE_TIME));
    }

    @Test
    public void q29() {

        String[] args = {};
        TestQ29.main(args);
    }

    @Test
    public void q41() {

        boolean b1 = false;
        boolean b2  = false;
        if (b2 = b1 == false){
            System.out.println("true");
        } else{
            System.out.println("false");
        }
    }

    @Test
    public void q42() {

        String s = "blooper";
        StringBuilder sb = new StringBuilder(s);
        String substring = s.substring(4);
        System.out.println(substring);
        sb.append(substring).delete(3, 5);
        System.out.println(sb);
    }

    @Test
    public void q45() {

        int a = 1 + 2 + 3 * 4;
        int b = 2 * 3 + 4;
        int total = a + b;
        System.out.println(total);
        assertThat(total, is(25));
    }

    @Test
    public void q46() {

        int i;
        int j;
        for (i = 0, j = 0 ; j < 1 ; ++j , i++){
            System.out.println( i + " " + j );
        }
        System.out.println( i + " " + j );
    }

    @Test
    public void q47() {

        String blank  = " ";  // one space
        String line = blank + "hello" + blank + blank;
        line.concat("world");
        String newLine  =  line.trim();
        System.out.println((int)(line.length() + newLine.length()));
    }

    @Test
    public void q48() {

        TestQ48 testQ48 = new TestQ48();
        String[] args = {};
        testQ48.main(args);
    }

}

class TestQ29{
    public static void main(String[] args){
        int j = 1;
        try{
            int i = doIt() / (j = 2);
        } catch (Exception e){
            System.out.println(" j = " + j);
        }
    }
    public static int doIt() throws Exception {  throw new Exception("FORGET IT");  }
}

class Automobile{
    public void drive() {  System.out.println("Automobile: drive");   }
}

class Truck extends Automobile{
    public void drive() {  System.out.println("Truck: drive");   }
    public static void main (String args [ ]){
        Automobile  a = new Automobile();
        Truck t  = new Truck();
        a.drive(); //1
        t.drive(); //2
        a = t;     //3
        a.drive(); //4
    }
}

/**
 * Given the following source code,
 * which of the lines that are commented out may be reinserted without introducing errors?
 */
abstract class Bang {
    //abstract void f();  //(0)
    final void g() {
    }

    //final    void h(){} //(1)
    protected static int i;
    private int j;
}

final class BigBang extends Bang {
    //BigBang(int n) { m = n; } //(2)
    public static void main(String args[]) {
        Bang mc = new BigBang();
    }

    void h() {
    }

    //void k(){ i++; } //(3) <==
    //void l(){ j++; } //(4)
    int m;
}

class TestClassQ10 {

    static String str = "Hello World";

    public static void changeIt(String s) {
        s = "Good bye world";
    }

    public static String method() {
        changeIt(str);
        return str;
    }
}

class AX{
    static int[] x = new int[0];
    static{
        x[0] = 10;
    }
}

class SomeThrowable extends Throwable { }
class MyThrowable extends SomeThrowable { }
class TestClassQ17{
    public static void main(String args[]) throws SomeThrowable{
        try{
            m1();
        }catch(SomeThrowable e){
            throw e;
        }finally{
            System.out.println("Done");
        }
    }
    public static void m1() throws MyThrowable{
        throw new MyThrowable();
    }
}

class Wrapper{
    int w = 10;
}

class TestQ18{

    static Wrapper changeWrapper(Wrapper w){
        w = new Wrapper();
        w.w += 9;
        return w;
    }

    public static void main(String[] args){
        Wrapper w = new Wrapper();
        w.w = 20;
        changeWrapper(w);
        w.w += 30;
        System.out.println(w.w);
        w = changeWrapper(w);
        System.out.println(w.w);
    }
}

 class TestQ48 {

    static String s = "";

    public static void m0(int a, int b) {
        s += a;
        m2();
        m1(b);
    }

    public static void m1(int i) {
        s += i;
    }

    public static void m2() {
        throw new NullPointerException("aa");
    }

    public static void m() {
        m0(1, 2);
        m1(3);
    }

    public static void main(String args[]) {
        try {
            m();
        } catch (Exception e) {
        }
        System.out.println(s);
    }
}