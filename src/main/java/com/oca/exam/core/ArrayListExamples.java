package com.oca.exam.core;


import java.util.*;

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

        System.out.println("** contains **");
        List<String> birds6 = new ArrayList();
        birds6.add("hawk");
        System.out.println(birds6.contains("hawk"));
        System.out.println(birds6.contains("robin"));

        System.out.println("** equals **");
        List<String> one = new ArrayList();
        List<String> two = new ArrayList();
        System.out.println(one.equals(two));
        one.add("a");
        System.out.println(one.equals(two));
        two.add("a");
        System.out.println(one.equals(two));
        one.add("b");
        two.add(0,"b");
        System.out.println(one.equals(two));
    }

    public static void wrapperClasses() {

        System.out.println("** Converting String to primitive **");
        System.out.println(Boolean.parseBoolean("true"));
        System.out.println(Byte.parseByte("1"));
        System.out.println(Short.parseShort("1"));
        System.out.println(Integer.parseInt("1"));
        System.out.println(Long.parseLong("1"));
        System.out.println(Float.parseFloat("1"));
        System.out.println(Double.parseDouble("1"));

        System.out.println("** Converting String to warpper class **");
        System.out.println(Boolean.valueOf("TRUE"));
        System.out.println(Byte.valueOf("2"));
        System.out.println(Short.valueOf("2"));
        System.out.println(Integer.valueOf("2"));
        System.out.println(Long.valueOf("2"));
        System.out.println(Float.valueOf("2.2"));
        System.out.println(Double.valueOf("2.2"));

    }

    public static void autoboxing() {

        System.out.println("** autoboxing **");
        List<Double> weights = new ArrayList<>();
        weights.add(50.5);
        weights.add(new Double(60));
        weights.remove(50.5);
        double first = weights.get(0);
        System.out.println(first);

        List<Integer> heights = new ArrayList<>();
        heights.add(null);
//        int h = heights.get(0); // NullPointerException

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.remove(1);
        System.out.println(numbers);

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(1);
        numbers2.add(2);
        numbers2.remove(new Integer(1));
        System.out.println(numbers2);
    }

    public static void convertingArray() {

        System.out.println("** Converting List to Array **");
        List<String> list = new ArrayList();
        list.add("hawk");
        list.add("robin");
        Object [] objectArray = list.toArray();
        System.out.println(objectArray.length);
        String [] stringArray = list.toArray(new String[0]);
        System.out.println(stringArray.length);

        System.out.println("** Converting List to Array **");
        String [] array = {"hawk", "robin"};
        List<String> arraylist = Arrays.asList(array);
        System.out.println(arraylist.size());
        list.set(1, "test");
        array[0] = "new";
        for (String b : array) System.out.println(b + " ");
        // list.remove(1); // throws UnsupportedOperation Exception

        System.out.println("** Converting varargs to List **");
        List<String> varlist = Arrays.asList("one", "two", "three");
        System.out.println(varlist.size());
    }

    public static void sorting () {

        System.out.println("** Sorting **");
        List<Integer> numbers = new ArrayList();
        numbers.add(99);
        numbers.add(5);
        numbers.add(81);
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public static void main(String...args) {

        creatingArrayList();
        usingArrayList();
        wrapperClasses();
        autoboxing();
        convertingArray();
        sorting();
    }
}
