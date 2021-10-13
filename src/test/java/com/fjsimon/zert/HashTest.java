package com.fjsimon.zert;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class HashTest {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public void setData(String magazine, String note) {

        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();

        String[] magazineWords = magazine.split("\\s+");
        String[] noteWords = note.split("\\s+");

        for (String m : magazineWords) {

            if (magazineMap.containsKey(m)) {
                magazineMap.put(m, magazineMap.get(m) + 1);
            } else {
                magazineMap.put(m, 1);
            }
        }

        for (String n : noteWords) {

            if (noteMap.containsKey(n)) {
                noteMap.put(n, noteMap.get(n) + 1);
            } else {
                noteMap.put(n, 1);
            }
        }
    }

    public boolean solve() {

        if (magazineMap.size() < noteMap.size()) {
            return false;
        } else {
            for (String key : noteMap.keySet()) {
                if (!magazineMap.containsKey(key)) {
                    return false;
                } else if (noteMap.get(key) > magazineMap.get(key)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test() {

        setData("two times three is not four", "two times two is four");
        assertThat(solve(), is(false));

        setData("give me one grand today night", "give one grand today");
        assertThat(solve(), is(true));
    }

}
