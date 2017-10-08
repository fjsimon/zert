package com.oca.exam.core;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CoreTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setup(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void test() {

        assertTrue(Boolean.parseBoolean("true"));

        assertFalse(Boolean.parseBoolean("TrUe") == new Boolean(null));

        assertFalse(new Boolean("TrUe") == new Boolean(true));

//        System.out.println(new Boolean() == false); // No Compile

        assertFalse(new Boolean("true") == Boolean.TRUE);

        assertTrue(new Boolean("no") == false);

        assertTrue(Boolean.parseBoolean("true"));

        assertFalse(new Boolean(null));

//        System.out.println(new Boolean());

        assertTrue(new Boolean("true"));

        assertTrue(new Boolean("trUE"));

    }

    @Test
    public void classname_test() {

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("mrx");
        String s = sb.toString();
        list.add(s);

        assertThat(s.getClass().toString(), is("class java.lang.String"));
        assertThat(list.getClass().toString(), is("class java.util.ArrayList"));
    }

    @Test
    public void test01_Q56() {

        ClassB b = new ClassB();
        b.method();
        assertThat(String.format("%d%n%d%n", 0, 4), CoreMatchers.is(outputStream.toString()));
    }

    @Test
    public void test01_Init() {

        ClassInit classInit = new ClassInit();
        assertThat(String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "a", "b", "c", "2", "3", "4", "1"),
                CoreMatchers.is(outputStream.toString()));
    }

    @Test
    public void stringFromCharTest(){
        String myStr = "good";
        char[] myCharArr = {'g', 'o', 'o', 'd' };

        String newStr = null;
        for(char ch : myCharArr){
            newStr = newStr + ch;
        }

        assertThat((newStr == myStr)+ " " + (newStr.equals(myStr)), is("false false"));
        assertThat(newStr, is("nullgood"));
        assertThat(myStr, is("good"));
    }

    @Test
    public void test01_Q49() {

        String s = "MINIMUM";
        assertThat(s.substring(4, 7), is("MUM")); //1
        assertThat(s.substring(5), is("UM")); //2
        assertThat(s.substring(s.indexOf('I', 3)), is("IMUM")); //3
        try {
            s.substring(s.indexOf('I', 4)); //4
            fail();
        }catch (StringIndexOutOfBoundsException e){

        }
    }

    @Test
    public void printerWriterTest(){
        OutputStreamWriter osw  =  new OutputStreamWriter( System.out );

        PrintWriter pw = new PrintWriter(osw);

        pw.write("hello");
        pw.close();
    }

    @Test
    public void test03_Q08() {
        int i = 0 ;
        int[] iA = {10, 20} ;
        iA[i] = i = 30 ;
        System.out.println(""+ iA[ 0 ] + " " + iA[ 1 ] + " "+i) ;

        assertThat(String.format("%s %s %s%n", "30", "20", "30"),
                CoreMatchers.is(outputStream.toString()));
    }

    @Test
    public void test03_Q44() {

        ClassQ44 tc = new ClassQ44();
        tc.looper();
        System.out.print(tc.x);

        assertThat(String.format("%s", "0"),
                CoreMatchers.is(outputStream.toString()));
    }

    @Test
    public void test03_Q45() {

        ClassQ45 classQ45 = new ClassQ45();
        classQ45.m();
    }

    @Test
    public void test03_Q48() {

        int var = 20, i=0;
        do{
            while(true){
                if( i++ > var) break;
            }
        }while(i<var--);

        assertThat(var, is(19));
    }

    @Test
    public void test03_Q49() {
        ClassQ49 tc = new ClassQ49();
        ( (I1) tc).m1();

        assertThat(String.format("%s%n", "Hello"),
                CoreMatchers.is(outputStream.toString()));
    }

    public static void stringTest(String s) {
        s.replace('h', 's');
    }
    public static void stringBuilderTest(StringBuilder s) {
        s.append("o");
    }

    @Test
    public void test03_Q38() {
        String s = "hell";
        StringBuilder sb = new StringBuilder("well");
        stringTest(s);
        stringBuilderTest(sb);
        System.out.print(s + sb);

        assertThat(String.format("%s", "hellwello"),
                CoreMatchers.is(outputStream.toString()));
    }

    @Test
    public void test03() {

        StringWrapper sw = new StringWrapper("How are you?");
        StringBuilder sb = new StringBuilder("How are you?");

        assertThat("Hello, "+sw, is(not("Hello, How are you?")));
        assertThat("Hello, "+sb, is("Hello, How are you?"));

    }

    @Test
    public void test04_Q12() {

        int INT1 = 0;
        int INT2 = 5;

        for(int i=INT1; i<INT2; i++){ System.out.println(i); }
        assertThat(String.format("%s%n%s%n%s%n%s%n%s%n", 0, 1, 2, 3, 4),
                CoreMatchers.is(outputStream.toString()));
        outputStream.reset();

        for(int i=INT1; i<INT2; System.out.println(++i));
        assertThat(String.format("%s%n%s%n%s%n%s%n%s%n", 1, 2, 3, 4, 5),
                CoreMatchers.is(outputStream.toString()));
        outputStream.reset();

        for(int i=INT1; i++<INT2; System.out.println(i));
        assertThat(String.format("%s%n%s%n%s%n%s%n%s%n", 1, 2, 3, 4, 5),
                CoreMatchers.is(outputStream.toString()));
        outputStream.reset();

        int i=INT1; while(i++<INT2) { System.out.println(i); }
        assertThat(String.format("%s%n%s%n%s%n%s%n%s%n", 1, 2, 3, 4, 5),
                CoreMatchers.is(outputStream.toString()));
        outputStream.reset();

        i=INT1; do { System.out.println(i); }while(i++<INT2);
        assertThat(String.format("%s%n%s%n%s%n%s%n%s%n%s%n", 0, 1, 2, 3, 4, 5),
                CoreMatchers.is(outputStream.toString()));
        outputStream.reset();

    }

    static void replaceString(String s) {
        s = s.replace('j', 'l');
    }
    static void replaceStringBuilder(StringBuilder s) {
        s.append("c");
    }

    @Test
    public void test04_Q68() {

        String s1 = new String("java");
        StringBuilder s2 = new StringBuilder("java");
        replaceString(s1);
        replaceStringBuilder(s2);
        System.out.println(s1 + s2);

        assertThat(String.format("%s%n", "javajavac"),
                CoreMatchers.is(outputStream.toString()));
    }

}

class ClassA {

    ClassA() { print(); }
    void print() { System.out.println("A"); }
}

class ClassB extends ClassA {

    int i =   4;
    public void method() { print(); }
    void print() { System.out.println(i); }
}

class ClassInit{

    public ClassInit(){ s1 = sM1("1"); }
    static String s1 = sM1("a");
    String s3 = sM1("2");
    { s1 = sM1("3"); }
    static{ s1 = sM1("b"); }
    static String s2 = sM1("c");
    String s4 = sM1("4");

    private static String sM1(String s){

        System.out.println(s);
        return s;
    }
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


class ClassQ49 implements I1, I2{

    public void m1() {
        System.out.println("Hello");
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

class StringWrapper {
    private String theVal;
    public StringWrapper(String str){ this.theVal = str; }
}