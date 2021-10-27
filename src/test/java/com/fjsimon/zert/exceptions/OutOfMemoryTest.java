package com.fjsimon.zert.exceptions;

import com.fjsimon.zert.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutOfMemoryTest extends BaseTest {

    static class Key {
        Integer id;
        BigInteger integ = BigInteger.ONE;
        char[] a = new char[10000000];
        List l = new ArrayList<>();

        Key(Integer id) {

            this.id = id;
        }

        @Override
        public int hashCode() {

            return id.hashCode();
        }
    }

    @Ignore
    @Test
    public void outOfMemoryTest() {

        Map m = new HashMap();
        while (true) {
            for (int i = 0; i < 1000; i++) {

                System.out.printf("Free memory (bytes): %s Size %s %n",
                        Runtime.getRuntime().freeMemory(), m.size());

                if (!m.containsKey(new Key(i)))
                    m.put(new Key(i), "Number:" + i);
            }
        }
    }
}
