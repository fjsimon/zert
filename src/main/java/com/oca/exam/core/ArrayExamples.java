package com.oca.exam.core;

import java.util.Arrays;

public class ArrayExamples {

    public static void creatingArray() {

        int[] arr = new int[3];
        int[] arr2 = new int[]{ 42, 55, 99};
        int[] arr3 = { 42, 55, 99};

        String [] bugs = {"cricket", "beetle", "ladybug"};
        String [] alias = bugs;
        System.out.println(bugs.equals(alias));
        System.out.println(bugs.toString());
        System.out.println(Arrays.toString(bugs));

    }

    public static void casting() {
        String [] strings = { "stringValue" };
        Object [] objects = strings;
        String [] againStrings = (String[]) objects;
//        againStrings[0] = new StringBuilder(); //NO COMPILE
//        objects[0] = new StringBuilder(); // Throws Exception at runtime
    }

    public static void usingArray() {

        String [] mammals = {"monkey", "chimp", "donkey"};
        System.out.println(mammals.length);
        System.out.println(mammals[0]);
        System.out.println(mammals[1]);
        System.out.println(mammals[2]);

        int [] numbers = new int[10];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 5;
        }

        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();
    }

    public static void sorting() {

        int [] numbers = {6, 9, 1};
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();
    }

    public static void searching() {

        int [] ordered = {2, 4, 6, 8}; // Ordered
        System.out.println(Arrays.binarySearch(ordered, 2));
        System.out.println(Arrays.binarySearch(ordered, 4));
        System.out.println(Arrays.binarySearch(ordered, 1));
        System.out.println(Arrays.binarySearch(ordered, 3));
        System.out.println(Arrays.binarySearch(ordered, 9));


        int [] unordered = {3, 2, 1}; // Un-Ordered
        System.out.println(Arrays.binarySearch(unordered, 2));
        System.out.println(Arrays.binarySearch(unordered, 3));

    }

    public static void main(String...args) {

        creatingArray();
        casting();
        usingArray();
        sorting();
        searching();
    }
}
