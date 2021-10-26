package com.fjsimon.zert.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MapTest {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {

        System.out.printf("Running %s:%n", name.getMethodName());
    }

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

    @Test
    public void printStackMapTest() {

        Map<Stack, String> map = new LinkedHashMap<>();
        map.put(new Stack("Arya"), "1");
        map.put(new Stack("Ned"), "2");
        map.put(new Stack("Sansa"), "3");
        map.put(new Stack("Bran"), "4");
        map.put(new Stack("Jaime"), "5");

        map.forEach((key, value) -> System.out.println(key.name + " " +value));
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

    @Test
    public void countDistincPairsTest() {

        int[] nums = {8, 12, 16, 4, 0, 20};
        int k = 4;

        assertThat(countDistinctPairs(nums, k), is(5));
    }
}
