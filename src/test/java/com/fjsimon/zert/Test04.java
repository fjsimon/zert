package com.fjsimon.zert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.fail;

public class Test04 extends BaseTest {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void test05_Q02() {

        Child b = new Child();
        b.fi = 20;
        System.out.println(b.fi);
        System.out.println(  (  (Parent) b  ).fi  );
    }

    static String[] days = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};

    @Test
    public void test05_Q03() {

        int index = 0;
        for (String day : days) {

            if (index == 3) {
                break;
            } else {
                continue;
            }

//            index++;
//            if(days[index].length()>3){
//                days[index] = day.substring(0,3);
//            }
        }
        System.out.println(days[index]);
    }

    @Test
    public void test05_Q16() {
        int[] a = { 1, 2, 3, 4 };
        int[] b = { 2, 3, 1, 0 };
        System.out.println( a [ (a = b)[3] ] );
    }

    @Test
    public void test05_Q18() {

        new TestClassQ18().m1();
    }

    @Test
    public void test05_Q19() {

        char i;
        LOOP:
        for (i = 0; i < 5; i++) {
            switch (i++) {
                case '0':
                    System.out.printf("%d %n", (int) i);
                    System.out.println("A");
                case 1:
                    System.out.printf("%d %n", (int) i);
                    System.out.println("B");
                    break LOOP;
                case 2:
                    System.out.printf("%d %n", (int) i);
                    System.out.println("C");
                    break;
                case 3:
                    System.out.printf("%d %n", (int) i);
                    System.out.println("D");
                    break;
                case 4:
                    System.out.printf("%d %n", (int) i);
                    System.out.println("E");
                case 'E':
                    System.out.printf("%d %n", (int) i);
                    System.out.println("F");
            }
        }
    }

    @Test
    public void loop_test() {

        int a = 5;

        loop:
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (a == 5) {
                    break loop;
                }
                System.out.println(i * j);
            }
        }
    }

    @Test
    public void test05_Q34() {
        int amount = 100, seed = 6;
        switch (new TestQ34().luckyNumber(6)) {
            case 3:
                amount = amount * 2;
            case 7:
                amount = amount * 2;
            case 6:
                amount = amount + amount;
            default:
        }

        assertThat(amount, is(400));
    }

    @Test
    public void test05_Q48() {

        int counter = 0;
        outer:
        for (int i = 0; i < 3; i++) {
            middle:
            for (int j = 0; j < 3; j++) {
                inner:
                for (int k = 0; k < 3; k++) {
                    if (k - j > 0) {
                        System.out.println("breaking middle " + j);
                        break middle;
                    }
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }

    @Test
    public void test05_Q53() {

        System.out.println( new SubClass() );
    }

    @Test
    public void test05_Q54() {

        boolean b = false;
        int i = 1;
        do {
            i++;
        } while (b = !b);
        System.out.println(i);
    }

    @Test(expected = NullPointerException.class)
    public void test05_Q57() {
        int ia[][] = { {1, 2}, null };
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                System.out.println(ia[i][j]);
    }

    @Test
    public void test05_Q56() {
        Float f = null;
        try{
            f = Float.valueOf("12.3");
            String s = f.toString();
            int i = Integer.parseInt(s);
            System.out.println("i = "+i);
            fail();
        }
        catch(Exception e){
            System.out.println("trouble : "+f);
        }
    }

    @Test()
    public void test05_Q64() {

        try {

//            LocalDateTime greatDay = LocalDateTime.parse("2015-01-01T11:44:44.789");//2
            LocalDateTime greatDay = LocalDateTime.parse("2015-01-01");//2
            fail();
            String greatDayStr = greatDay.format(DateTimeFormatter.ISO_DATE_TIME); //3
            System.out.println(greatDayStr);//4

        } catch (DateTimeParseException e) {

            assertThat(e.getMessage(), is("Text '2015-01-01' could not be parsed at index 10"));
        }
    }

}

class Parent {
    final int fi = 10;
}

class Child extends Parent {
    int fi = 15;
}

class Super{
    public String toString(){
        return "4";
    }
}

class SubClass extends Super{
    public String toString(){
        return super.toString()+"3";
    }
}

class TestClassQ18 {

    char c;

    public void m1() {
        char[] cA = {'a', 'b'};
        m2(c, cA);
        System.out.println(((int) c) + "," + cA[1]);
    }

    public void m2(char c, char[] cA) {
        c = 'b';
        cA[1] = cA[0] = 'm';
    }
}

class TestQ34 {

    public int luckyNumber(int seed) {
        if (seed > 10) return seed % 10;
        int x = 0;
        try {
            if (seed % 2 == 0) throw new Exception("No Even no.");
            else return x;
        } catch (Exception e) {
            return 3;
        } finally {
            return 7;
        }
    }
}