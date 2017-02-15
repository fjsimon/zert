package com.oca.exam.extra.features.lambda;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Map.computeIfAbsent
public class Fibonacci {

    private Map<Integer, Integer> cache = new ConcurrentHashMap<>();

    public int get(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return cache.computeIfAbsent(n, key -> get(n - 2) + get(n - 1));
    }

}
