package com.design.pattern.concurrency.demos;


import java.util.ArrayList;
import java.util.List;

public class DataBuffer {

    private final static int MAX = 10;
    private List<String> items = new ArrayList<>();

    DataBuffer(){
        super();
    }

    DataBuffer(String prefix){
        for(int i = 0; i < MAX; i++){
            String item = prefix + i;
            System.out.printf("Adding %s%n", item);
            items.add(item);
        }
    }

    void add(String s) {
        if (!isFull()) {
            items.add(s);
        }
    }

    boolean isEmpty() {
        return items.size() == 0;
    }

    boolean isFull() {
        return items.size() == MAX;
    }

    String remove() {
        if(!isEmpty()) {
            return items.remove(0);
        }
        return null;
    }
}
