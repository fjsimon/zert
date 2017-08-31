package com.oca.exam.core;


import java.util.HashMap;
import java.util.HashSet;
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

        int[] nums = {8, 12, 16, 4, 0, 20};
        int k = 4;
        System.out.println(countDistinctPairs(nums, k));
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

    private static int countDistinctPairs(int[] nums, int k) {

        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        HashSet<String> set = new HashSet<String>();
        for(int i =0;i < nums.length;i++){
            map.put(nums[i],true);
        }
        for (int i = 0 ; i < nums.length; i++){
            if(map.containsKey(nums[i]+k)){
                String a = "";
                if(nums[i]<nums[i]+k){
                    a = "("+nums[i]+","+(nums[i]+k)+")";
                }
                else{
                    a = "("+(nums[i] + k)+","+nums[i]+")";
                }
                set.add(a);
            }
        }
        System.out.println(set);
        return set.size();
    }
}
