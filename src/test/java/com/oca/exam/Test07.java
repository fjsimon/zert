package com.oca.exam;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;

public class Test07 {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

    public void processList(ArrayList<DataHolder> dataList, Process p){
        for(DataHolder d: dataList){
            p.process(d.value, d.value);
        }
    }

    @Test
    public void q01() {

        ArrayList<DataHolder> al = new ArrayList<DataHolder>();
        al.add(new DataHolder(1));
        al.add(new DataHolder(2));
        al.add(new DataHolder(3));

        processList(al, (int a, int b)->System.out.println(a*b) );

        processList(al, (a, b)->System.out.println(a*b));

        processList(al, (a, b) ->{  System.out.println(a*b); } );
    }

    @Test
    public void q05() {

        boolean[] b1 = new boolean[2];
        boolean[] b2 = {true , false};
        System.out.println( "" + (b1[0] == b2[0]) + ", "+ (b1[1] == b2[1])  );
    }

    @Test
    public void q06() {

        for( ;Math.random()<0.5; ){ System.out.println("true"); }

        for(;;){ if(Math.random()<.05) break; }

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
}


interface Process {
    public void process(int a, int b);
}

class DataHolder {
    int value;
    DataHolder(int value){
        this.value = value;
    }
}

class T06Q02 {

    void probe(int... x) { System.out.println("In ..."); }  //1

    void probe(Integer x) { System.out.println("In Integer"); } //2

    void probe(long x) { System.out.println("In long"); } //3

    void probe(Long x) { System.out.println("In LONG"); } //4

    public static void main(String[] args) {

        Integer a = 4;
        new T06Q02().probe(a); //5

        int b = 4;
        new T06Q02().probe(b); //6

        new T06Q02().probe(b, b); //6
    }
}

class T06Q04 {

    static String url = "jdbc://derby://localhost:1527//mydb";

    static T06Q04 getDatabase() {
        System.out.println("Getting DB");
        return null;
    }

    public static void main(String[ ] args) {
        System.out.println( getDatabase().url );
    }
}

class BaseClassQ09{

    public void print(String s) {
        System.out.println("BaseClass : "+s);
    }
}

class SubClassQ09 extends BaseClassQ09{

    public void print(String s){
        System.out.println("SubClass : "+s);
        super.print(s);
    }

    public static void main(String args[]){
        SubClassQ09 sc = new SubClassQ09();
        sc.print("location");
    }
}