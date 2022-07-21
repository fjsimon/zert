package com.fjsimon.zert.core;

import com.fjsimon.zert.BaseTest;
import org.junit.Test;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

public class CoreTest extends BaseTest {

    @SuppressWarnings("deprecation")
	@Test
    public void booleanTest() {

        assertThat(Boolean.parseBoolean("true"), is(true));

        assertThat(Boolean.parseBoolean("TrUe") == new Boolean(null), is(false));

        assertThat(new Boolean("TrUe") == new Boolean(true), is(false));

        assertThat(new Boolean("TrUe").equals(new Boolean(true)), is(true));

//        System.out.println(new Boolean() == false); // No Compile

        assertThat(new Boolean("true") == Boolean.TRUE, is(false));

        assertThat(new Boolean("no") == false, is(true));

        assertThat(Boolean.parseBoolean("true"), is(true));

        assertThat(new Boolean(null), is(false));

//        System.out.println(new Boolean());  // No Compile

        assertThat(new Boolean("true"), is(true));

        assertThat(new Boolean("trUE"), is(true));

        assertThat(new Boolean("TRUE"), is(true));

    }

    
	@Test
    public void charTest() {

		char xi = '\u559c';
		assertThat(xi, is('喜'));
		
		char \u559c = '\u559c';
        assertThat(\u559c, is('喜'));
        
        char newline = '\n';
        assertThat(newline, is('\n'));
        
        char backspace = '\b';
        assertThat(backspace, is('\b'));

        char horizontalTab = '\t';
        assertThat(horizontalTab, is('\t'));
        
        char formFeed = '\f';
        assertThat(formFeed, is('\f'));
        
        char carriageReturn = '\r';
        assertThat(carriageReturn, is('\r'));
        
        char doubleQuote = '\"';
        assertThat(doubleQuote, is('\"'));
        
        char singleQuote = '\'';
        assertThat(singleQuote, is('\''));
        
        char backslash = '\\';
        assertThat(backslash, is('\\'));
        
        char largestOctalEscapeValue = '\377';
        assertThat(largestOctalEscapeValue, is('ÿ'));
    }
	
    @Test
    public void classname_test() {

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("mrx");
        Object object = new ClassA();
        ClassA clase1 = new ClassB();
        ClassB clase2 = new ClassB();
        String s = sb.toString();
        list.add(s);
//        clase1.method(); // No compile
        clase2.method();

        assertThat(s.getClass().toString(), is("class java.lang.String"));
        assertThat(list.getClass().toString(), is("class java.util.ArrayList"));
        assertThat(object.getClass().toString(), is("class com.fjsimon.zert.core.ClassA"));
        assertThat(clase1.getClass().toString(), is("class com.fjsimon.zert.core.ClassB"));
        assertThat(clase2.getClass().toString(), is("class com.fjsimon.zert.core.ClassB"));
    }

    @Test
    public void test01_Q56() {

        ClassB b = new ClassB();
        b.method();
    }

    @Test
    public void test01_Init() {

        new ClassInit();
    }

    @Test
    public void stringFromCharTest() {
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

        try {
            s.substring(4, 8); //5
            fail();
        }catch (StringIndexOutOfBoundsException e){

        }

    }

    @Test
    public void printerWriterTest() {
        OutputStreamWriter osw  =  new OutputStreamWriter( System.out );

        PrintWriter pw = new PrintWriter(osw);

        pw.write("hello");
        pw.close();
    }


    @Test
    public void ambiguous_method_call_test() {
//        a(5);
    }

    static void a(int a, int... b) {
        System.out.print(a);
    }

    static void a(int... b) {
        System.out.print(b);
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



