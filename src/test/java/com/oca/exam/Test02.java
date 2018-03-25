package com.oca.exam;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.rules.TestName;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Test02 {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void q01() {

        StringWrapper sw = new StringWrapper("How are you?");
        StringBuilder sb = new StringBuilder("How are you?");

        assertThat("Hello, "+sw, Matchers.is(not("Hello, How are you?")));
        assertThat("Hello, "+sb, Matchers.is("Hello, How are you?"));
    }

    public float parseFloat(String s) {
        float f = 0.0f;
        try {
            f = Float.valueOf(s).floatValue();
            return f;
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input " + s);
            f = Float.NaN;
            return f;
        } finally {
            System.out.println("finally");
        }

    }

    @Test
    public void q04() {

        assertThat(parseFloat("1"), Matchers.is(1.0F));
    }

    public static void printSum(int a, int b) {

        System.out.println("In int " + (a + b));
    }

    public static void printSum(Integer a, Integer b) {

        System.out.println("In Integer " + (a + b));
    }

    public static void printSum(double a, double b) {

        System.out.println("In double " + (a + b));
    }

    @Test
    public void q06() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        printSum(1, 2);
        Assert.assertThat("In int 3\n", CoreMatchers.is(outputStream.toString()));
    }

    @Test
    public void q07() {
        int i = 4;
        int ia[][][] = new int[i][i = 3][i];
        System.out.println( ia.length + ", " + ia[0].length+", "+ ia[0][0].length);

        assertThat(ia.length, is(4));
        assertThat(ia[0].length, is(3));
        assertThat(ia[0][0].length, is(3));
    }

    @Test
    public void q08() {
        int i = 0 ;
        int[] iA = {10, 20} ;
        iA[i] = i = 30 ;
        System.out.println(""+ iA[ 0 ] + " " + iA[ 1 ] + " "+i) ;

        assertThat(iA[0], is(30));
        assertThat(iA[1], is(20));
        assertThat(i, is(30));
    }

    public static void stringTest(String s) {

        s.replace('h', 's');
    }

    public static void stringBuilderTest(StringBuilder s) {

        s.append("o");
    }

    @Test
    public void q22() {

        Object obj1 = new Object();
        Object obj2 = obj1;
        if (obj1.equals(obj2)) System.out.println("true");
        else System.out.println("false");
    }

    @Test
    public void q38() {
        String s = "hell";
        StringBuilder sb = new StringBuilder("well");
        stringTest(s);
        stringBuilderTest(sb);
        assertThat(s + sb, is("hellwello"));
    }

    @Test
    public void q44() {

        ClassQ44 tc = new ClassQ44();
        tc.looper();
        assertThat(tc.x, is(0));
    }

    @Test
    public void q45() {

        ClassQ45 classQ45 = new ClassQ45();
        classQ45.m();
    }

    @Test
    public void q48() {

        int var = 20, i=0;
        do{
            while(true){
                if( i++ > var) break;
            }
        }while(i<var--);

        assertThat(var, Matchers.is(19));
    }

    @Test
    public void q49() {

        ClassQ49 tc = new ClassQ49();
        ( (I1) tc).m1();
    }

    @Test
    public void q70() {

        int sum = 0;
        for (int i = 0, j = 10; sum > 20; ++i, --j) {  // 1
            sum = sum + i + j;
        }
        System.out.println("Sum = " + sum);
    }
}

class StringWrapper {

    private String theVal;
    public StringWrapper(String str){ this.theVal = str; }
}

class ClassQ44 {

    int x = 5;
    int getX() { return x; }

    public void looper(){
//        int x = 0; // Error
        while( (x = getX()) != 0 ){
            for(int m = 10; m>=0; m--){
                x = m;
            }
        }
    }
}

class ClassQ45 {

    int a;
    int b = 0;
    static int c;
    public void m(){
        int d;
        int e = 0;
        // Line 1

        a++;
        b++;
        c++;
//        d++; //Compilation error.
        e++;
    }
}


interface I1{

    int VALUE = 1;
    void m1();
}

interface I2{

    int VALUE = 2;
    void m1();
}

class ClassQ49 implements I1, I2 {

    public void m1() {

        System.out.println("Hello");
    }
}