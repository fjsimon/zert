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

    public static void usingArrayList() {

        System.out.println("** add **");
        ArrayList list = new ArrayList();
        list.add("hawk");
        list.add(Boolean.TRUE);
        System.out.println(list);

        ArrayList<String> safer = new ArrayList();
        safer.add("sparrow");
//        safer.add(Boolean.TRUE); // DOES NOT COMPILE

        List<String> birds = new ArrayList();
        birds.add("hawk");
        birds.add(1, "robin");
        birds.add(0,"blue jay");
        birds.add(1, "cardinal");
        System.out.println(birds);

        System.out.println("** remove **");
        List<String> birds2 = new ArrayList();
        birds2.add("hawk");
        birds2.add("hawk");
        System.out.println(birds2.remove("cardinal"));
        System.out.println(birds2.remove("hawk"));
        System.out.println(birds2.remove(0));
        System.out.println(birds2);

        System.out.println("** set **");
        List<String> birds3 = new ArrayList();
        birds3.add("hawk");
        System.out.println(birds3.size());
        birds3.set(0, "robin");
        System.out.println(birds3.size());
//        birds3.set(1, "robin"); // indexOutOfBoundsException

        System.out.println("** isEmpty and size **");
        List<String> birds4 = new ArrayList();
        System.out.println(birds4.isEmpty());
        System.out.println(birds4.size());
        birds4.add("hawk");
        birds4.add("hawk");
        System.out.println(birds4.isEmpty());
        System.out.println(birds4.size());

        System.out.println("** clear **");
        List<String> birds5 = new ArrayList();
        birds5.add("hawk");
        birds5.add("hawk");
        System.out.println(birds5.isEmpty());
        System.out.println(birds5.size());
        birds5.clear();
        System.out.println(birds5.isEmpty());
        System.out.println(birds5.size());

    }

    public static void main(String...args) {

        creatingArrayList();
        usingArrayList();
    }
}
