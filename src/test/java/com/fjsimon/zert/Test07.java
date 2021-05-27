package com.fjsimon.zert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.time.*;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Test07 {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    public void processList(ArrayList<DataHolder> dataList, Process p) {
        for (DataHolder d : dataList) {
            p.process(d.value, d.value);
        }
    }

    @Test
    public void q01() {

        ArrayList<DataHolder> al = new ArrayList<DataHolder>();
        al.add(new DataHolder(1));
        al.add(new DataHolder(2));
        al.add(new DataHolder(3));

        processList(al, (int a, int b) -> System.out.println(a * b));

        processList(al, (a, b) -> System.out.println(a * b));

        processList(al, (a, b) -> {
            System.out.println(a * b);
        });
    }

    @Test
    public void q05() {

        boolean[] b1 = new boolean[2];
        boolean[] b2 = {true, false};
        System.out.println("" + (b1[0] == b2[0]) + ", " + (b1[1] == b2[1]));
    }

    @Test
    public void q06() {

        for (; Math.random() < 0.5; ) {
            System.out.println("true");
        }

        for (; ; ) {
            if (Math.random() < .05) break;
        }

//        for(;;Math.random()){ System.out.println("true"); }
    }

    @Test
    public void q08() {

        for (int i = 0; i < 10; i++) System.out.print(i + " ");  //1
        for (int i = 10; i > 0; i--) System.out.print(i + " ");  //2
        int i = 20;                  //3
        System.out.print(i + " ");   //4
    }

    @Test
    public void q11() {

        if (true)
            if (false)
                System.out.println("True False");
            else
                System.out.println("True True");
    }

    @Test
    public void q16() {

//        int condition = 2;
//        Byte condition = 1;
        Integer condition = new Integer("1");
        switch (condition) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
        }

    }

    @Test
    public void q17() {

        String[][][] arr = {{{"a", "b", "c"}, {"d", "e", null}}, {{"x"}, null}, {{"y"}}, {{"z", "p"}, {}}};
        System.out.println(arr[0][1][2]);
    }

    @Test(expected = NumberFormatException.class)
    public void q18() {

        int value = Integer.parseInt(null);
    }

    public void printUsefulData(ArrayList<Data> dataList, Predicate<Data> p) {
        for (Data d : dataList) {
            if (p.test(d)) System.out.println(d.value);
        }
    }

    @Test
    public void q19() {

        ArrayList<Data> al = new ArrayList<Data>();
        al.add(new Data(1));
        al.add(new Data(2));
        al.add(new Data(3));

        printUsefulData(al, d -> d.value > 2);

        printUsefulData(al, (Data d) -> {
            return d.value > 2;
        });

    }

    @Test
    public void q22() {

        try {
            RuntimeException re = null;
            throw re;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void q24() {

        ArrayList<String> al = new ArrayList<>();
        al.add("111");
        al.add("222");
        System.out.println(al.get(al.size()));
    }

    @Test
    public void q26() {

        Object t = new Integer(106);
        int k = ((Integer) t).intValue() / 10;
        System.out.println(k); // int

        System.out.println(100 / 9.9); // double

        System.out.println(100 / 10.0); // double

        System.out.println(100 / 10); // int

        System.out.println(3 + 100 / 10 * 2 - 13); // int => 3 + ((100 / 10) * 2) - 13
    }

    public static void ifTest(boolean flag) {
        if (flag)   //1
            if (flag)   //2
                if (flag)   //3
                    System.out.println("False True");
                else        //4
                    System.out.println("True False");
            else        //5
                System.out.println("True True");
        else        //6
            System.out.println("False False");
    }

    @Test
    public void q31() {

        ifTest(true);
        ifTest(false);
    }

    @Test
    public void q32() {

        LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);

        ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
        date = date.plus(Duration.ofDays(1));
        System.out.println(date);

        date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
        date = date.plus(Period.ofDays(1));
        System.out.println(date);
    }

    @Test
    public void q36() {

        StringBuilder sb = new StringBuilder("asdf");
        String str1 = sb.toString();
        String str2 = sb.toString();
        System.out.println(str1 == str2);

        str1 = sb.toString();
        str2 = str1;
        System.out.println(str1 == str2);

//        String str1 = sb.toString();
//        System.out.println(str1 == sb);

        System.out.println(sb == new StringBuilder(sb));
    }

    @Test
    public void q37() {

        int i = 0, j = 11;
        do {
            System.out.println(i + "  " + j);
            if (i > j) {
                break;
            }
            j--;
        } while (++i < 5);

        System.out.println(i + "  " + j);
    }
}


interface Process {
    public void process(int a, int b);
}

class DataHolder {
    int value;

    DataHolder(int value) {
        this.value = value;
    }
}

class T06Q02 {

    void probe(int... x) {
        System.out.println("In ...");
    }  //1

    void probe(Integer x) {
        System.out.println("In Integer");
    } //2

    void probe(long x) {
        System.out.println("In long");
    } //3

    void probe(Long x) {
        System.out.println("In LONG");
    } //4

    public static void main(String[] args) {

        Integer a = 4;
        new T06Q02().probe(a); //5

        int b = 4;
        new T06Q02().probe(b); //6

        new T06Q02().probe(b, b); //6
    }
}

class T07Q04 {

    static String url = "jdbc://derby://localhost:1527//mydb";

    static T07Q04 getDatabase() {
        System.out.println("Getting DB");
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getDatabase().url);
    }
}

class BaseClassQ09 {

    public void print(String s) {
        System.out.println("BaseClass : " + s);
    }
}

class SubClassQ09 extends BaseClassQ09 {

    public void print(String s) {
        System.out.println("SubClass : " + s);
        super.print(s);
    }

    public static void main(String args[]) {
        SubClassQ09 sc = new SubClassQ09();
        sc.print("location");
    }
}

class NewException extends Exception {
}

class AnotherException extends Exception {
}

class T07Q23 {

    public static void main(String[] args) throws Exception {
        try {
            m2();
        } finally {
            m3();
        }
    }

    public static void m2() throws NewException {
        throw new NewException();
    }

    public static void m3() throws AnotherException {
        throw new AnotherException();
    }
}

class T07Q28 {
    public static void main(String args[]) {
        try {
            m1();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("1");
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("2");
            return;
        } catch (Exception e) {
            System.out.println("3");
        } finally {
            System.out.println("4");
        }
        System.out.println("END");
    }

    static void m1() {
        System.out.println("m1 Starts");
        throw new IndexOutOfBoundsException("Big Bang ");
    }
}

class T07Q33 {
    public static void main(String[] args) {
        calculate(2);
    }

    public static void calculate(int x) {
        String val;
        switch (x) {
            case 2:
            default:
                val = "def";
        }
        System.out.println(val);
    }
}

 class T07Q41 {

    public void testRefs(String str, StringBuilder sb) {

        str = str + sb.toString();
        sb.append(str);
        str = null;
        sb = null;
    }

    public static void main(String[] args) {

        String s = "aaa";
        StringBuilder sb = new StringBuilder("bbb");
        new T07Q41().testRefs(s, sb);
        System.out.println("s="+s+" sb="+sb);
    }
}