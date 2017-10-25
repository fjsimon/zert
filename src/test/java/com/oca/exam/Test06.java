package com.oca.exam;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Test06 {

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