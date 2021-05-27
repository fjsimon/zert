package com.fjsimon.zert;

public class Test {

    public static void add(int a){
        loop: for(int i=1; i<3; i++){
            for(int j=1; j<3; j++) {
                if(a == 5){
                    break loop;
                }
                System.out.println(i*j);
            }
        }
    }

    public static void test() {
        int[] a = {1};
        Test t = new Test();
        t.increment(a);
        System.out.printf("a[a.length - 1] %s%n", a[a.length - 1]);
    }

    void increment(int[] i) {
        i[i.length - 1]++;
    }

    public static void main(String ...args){

        add(5);
        test();
    }
}

