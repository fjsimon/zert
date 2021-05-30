package com.fjsimon.zert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class Test06 {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    public LocalDate process(LocalDate ld) {

        LocalDate ld2 = ld.plus(Period.of(0, 0, 31));
        return ld2;
    }

    @Test
    public void q04() {
        LocalDate now = LocalDate.now();
        assertThat(process(now).getMonthValue(), is((now.getMonthValue() + 1) % 12));
        assertThat(process(now).getDayOfMonth(), is(now.getDayOfMonth()));
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

        assertThat(T06Q10.method(), is("Hello World"));
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
        T06Q29.main(args);
    }

    @Test
    public void q32() {

        Integer a = 1, b = 2;
        Double c = 1.0, d = 2.0;
        Short e = 1;

        assertThat(c.equals(c), is(true));
        assertThat(c == c, is(true));

        assertThat(a.equals(e), is(false));

    }

    @Test
    public void q35() {

        List s1 = new ArrayList();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        s1.add("a");
        if (s1.remove("a")) {
            if (s1.remove("a")) {
                s1.remove("b");
            } else {
                s1.remove("c");
            }
        }
        System.out.println(s1);
    }

    @Test
    public void q38() {

        char cA[][] = new char[3][];
        for (int i=0; i<cA.length; i++)
            cA[i] = new char[4];

        System.out.println(cA[2][3]);
        assertThat(cA[2][3], is('\u0000'));
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

        T06Q48 testQ48 = new T06Q48();
        String[] args = {};
        testQ48.main(args);
    }

    @Test
    public void q57() {

        String a = "java";
        char[] b = { 'j', 'a', 'v', 'a' };
        String c = new String(b);
        String d = a;

        assertThat((a == d), is(true));
        assertThat((a == "java"), is(true));
        assertThat((a.equals(c)), is(true));
    }

    @Test
    public void q60() {

        String[] dataList = {"x", "y", "z"};
        for (String dataElement : dataList) {
            int innerCounter = 0;
            while (innerCounter < dataList.length) {
                System.out.println(dataElement + ", " + innerCounter);
                innerCounter++;
            }
        }
    }

    @Test
    public void q61() {

        Integer i1 = 1;
        Integer i2 = new Integer(1);
        int i3 = 1;
        Byte b1 = 1;
        Long g1 = 1L;

        assertThat(i1 == i2, is(false));
        assertThat(i1 == i3, is(true));
        assertThat(i1.equals(i2), is(true));
        assertThat(i1.equals(g1), is(false));
        assertThat(i1.equals(b1), is(false));


    }

    public String getDateString(LocalDateTime ldt){
        return DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ldt);
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void q63() {

        getDateString(LocalDateTime.now());
    }

    @Test
    public void q66() {

        StringBuilder sb1 = new StringBuilder(100);
        assertThat(sb1.capacity(), is(100));

        StringBuilder sb2 = new StringBuilder();
        sb2.ensureCapacity(100);
        assertThat(sb2.capacity(), is(100));
    }

    @Test
    public void q67() {

        int a = 5, b = 7, k1 = 0, k2 = 0, k3 = 0;
        Integer m = null;

        k1 = new Integer(a) + new Integer(b);  //1
        k2 = new Integer(a) + b; //2
        k3 = a + new Integer(b); //3
        m = new Integer(a) + new Integer(b); //4

        assertThat(k1, is(12));
        assertThat(k2, is(12));
        assertThat(k3, is(12));
        assertThat(m, is(12));

    }

    @Test
    public void q68() {

        LocalDateTime dt = LocalDateTime.parse("2015-01-02T17:13:50");

        assertThat(dt.format(java.time.format.DateTimeFormatter.ISO_DATE_TIME), is("2015-01-02T17:13:50"));

        assertThat(dt.toString(), is("2015-01-02T17:13:50"));

    }
}

class T06Q29 {

    public static void main(String[] args){
        int j = 1;
        try{
            int i = doIt() / (j = 2);
        } catch (Exception e){
            System.out.println(" j = " + j);
        }
    }

    public static int doIt() throws Exception {
        throw new Exception("FORGET IT");
    }
}

class T06Q32 {

    public static void main(String args[]) {
        int i = 0;
        for (i = 1; i < 5; i++) continue;  //(1)
        for (i = 0; ; i++) break;       //(2)
        for (; i < 5 ? false : true; ) ;     //(3)
    }
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

class T06Q10 {

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
class T06Q17{
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

class T06Q18{

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

class T06Q48 {

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

interface Pow{
    static void wow(){
        System.out.println("In Pow.wow");
    }
}

abstract class Wow{
    static void wow(){
        System.out.println("In Wow.wow");
    }
}

class T06Q52 extends Wow implements Pow {
    public static void main(String[] args) {
        T06Q52 f = new T06Q52();
        f.wow();
    }
}

class Data {
    int value;

    Data(int value) {
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }

    public static void main(String[] args) {
        Data[] dataArr = new Data[]{new Data(1), new Data(2), new Data(3), new Data(4)};

        List<Data> dataList = Arrays.asList(dataArr); //1

        for (Data element : dataList) {
            dataList.removeIf((Data d) -> {
                return d.value % 2 == 0;
            });  //2

//            System.out.println("Removed "+d+", "); //3 Compiled error
        }
    }
}
