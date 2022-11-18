package com.fjsimon.zert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.io.IOException;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UniqueTest01 extends BaseTest {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    @Test
    public void q2() {

        int b = 0b01001110_00100000;

        System.out.println(b);

    }

    @Test
    public void q5(){

        String[] args = {"one"};

        try{
            int i = 0;
            i =  Integer.parseInt( args[0] );
        }
        catch(NumberFormatException e){
//            System.out.println("Problem in " + i );
        }
    }

    @Test
    public void q9() {
        int rate = 10;
        long amount = 1 - rate/100*1 - rate/100;

        System.out.println(amount);
    }

    @Test
    public void q19() {

        System.out.println(1 + 5 < 3 + 7);
        System.out.println( (2 + 2) >= 2 + 3);
    }

    @Test
    public void q37(){

        String myStr = "good";
        char[] myCharArr = {'g', 'o', 'o', 'd' };

        String newStr = "";
        for(char ch : myCharArr){
            newStr = newStr + ch;
        }
        boolean b1 = newStr == myStr;
        boolean b2 = newStr.equals(myStr);

        System.out.println(b1+ " " + b2);
    }

    @Test
    public void q45() {
        assertThat(parseFloat("0.0"), is(10.0f));

    }

    public float parseFloat( String s ){
        float f = 0.0f;
        try{
            f = Float.valueOf( s ).floatValue();
            return f ;
        }
        catch(NumberFormatException nfe){
            f = Float.NaN ;
            return f;
        }
        finally{
            f = 10.0f;
            return f;
        }
    }

    @Test
    public void q48() {

        int i=0, j=0;
        X1: for(i = 0; i < 3; i++){
            X2: for(j = 3; j > 0; j--){
                if(i < j)
                    continue X1;
                else
                    break X2;
            }
        }
        System.out.println(i+" "+j);
    }
}

class TestClassQ1 {

    public static void doStuff() throws Exception{
        System.out.println("Doing stuff...");
        if(Math.random()>0.4){
            throw new Exception("Too high!");
        }
        System.out.println("Done stuff.");
    }

    public static void main(String[] args) throws Exception {
        doStuff();
        System.out.println("Over");
    }
}

class UniqueTestClassQ18{
    static int a;
    int b;
    public UniqueTestClassQ18() {
        int c;
        c = a;
        a++;
        b += c;
    }

    public static void main(String args[]) {
        UniqueTestClassQ18 uniqueTestClassQ18 = new UniqueTestClassQ18();
        System.out.println(uniqueTestClassQ18.a);
        System.out.println(uniqueTestClassQ18.b);
    }
}

class UniqueTestClassQ20{
    void probe(Object x) { System.out.println("In Object"); } //3

    void probe(Number x) { System.out.println("In Number"); } //2

    void probe(Integer x) { System.out.println("In Integer"); } //2

    void probe(Long x) { System.out.println("In Long"); } //4

    public static void main(String[] args){
        double a = 10;
        new UniqueTestClassQ20().probe(a);
    }
}

class UniqueTestClassQ21{
    static boolean b;
    static int[] ia = new int[1];
    static char ch;
    static boolean[] ba = new boolean[1];
    public static void main(String args[]) throws Exception{
        boolean x = false;
        if( b ){
            x = ( ch == ia[ch]);
        }
        else
            x = ( ba[ch] = b );
        System.out.println(x+" "+ba[ch]);
    }
}


interface I { }

class UA implements I{
    public String toString(){ return "in a"; }
}

class UB extends UA{
    public String toString(){ return "in b"; }
}


class UniqueTestClassQ22 {

    public static void main(String[] args) {
        UB b = new UB();
        UA a = b;
        I i = a;

        System.out.println(i);
        System.out.println((UB)a);
        System.out.println(b);

    }
}

interface House{
    public default String getAddress(){
        return "101 Main Str";
    }
}

interface Bungalow extends House{
    public default String getAddress(){
        return "101 Smart Str";
    }
}

class MyHouse implements Bungalow, House{

}
class UniqueTestClassQ23 {

    public static void main(String[] args) {
        House ci = new MyHouse();  //1
        System.out.println(ci.getAddress()); //2
    }
}

class UniqueTestClassQ26{
    int i;
    public UniqueTestClassQ26(int i) { this.i = i;  }
    public String toString(){
        if(i == 0) return null;
        else return ""+i;
    }
    public static void main(String[ ] args){
        UniqueTestClassQ26 t1 = new UniqueTestClassQ26(0);
        UniqueTestClassQ26 t2 = new UniqueTestClassQ26(2);
        System.out.println(t2);
        System.out.println(""+t1);
    }


}

class UniqueTestClassQ49{
    static int a = 0;
    int b = 5;

    public void foo(){
        while(b>0){
            b--;
            a++;
        }
    }

    public static void main(String[] args) {
        UniqueTestClassQ49 p1 = new UniqueTestClassQ49();
        p1.foo();
        UniqueTestClassQ49 p2 = new UniqueTestClassQ49();
        p2.foo();

        System.out.println(p1.a+" "+p2.a);
    }
}
