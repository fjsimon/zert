package com.oca.exam.core;


import java.util.ArrayList;
import java.util.List;

public class ArrayListExamples {

    public static void creatingArrayList() {

        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList(10);
        ArrayList list3 = new ArrayList(list2);
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<>();
        List<String> list6 = new ArrayList<>();
//        ArrayList<String> list7 = new List<>(); DOES NOT COMPILE
    }

    public static void main(String...args) {

        creatingArrayList();
    }
}
