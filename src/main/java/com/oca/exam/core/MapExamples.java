package com.oca.exam.core;


import java.util.LinkedHashMap;
import java.util.Map;

public class MapExamples {

    static class Stack {
        String name;
        Stack(String name){
            this.name = name;
        }

        public boolean equals(Object o) {
            return ((Stack)o).name.length() == this.name.length();
        }

        public int hashCode() {
            return 4000 << 2 * 2000 / 10000;
        }
    }

    public static void main(String... args) {

        printStackMap();
    }

    private static void printStackMap() {
        Map<Stack, String> map = new LinkedHashMap<>();
        map.put(new Stack("Arya"), "1");
        map.put(new Stack("Ned"), "2");
        map.put(new Stack("Sansa"), "3");
        map.put(new Stack("Bran"), "4");
        map.put(new Stack("Jaime"), "5");

        map.forEach((k, v) -> System.out.println(v.toString()));
    }
}
