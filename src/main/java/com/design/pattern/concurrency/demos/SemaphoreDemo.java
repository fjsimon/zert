package com.design.pattern.concurrency.demos;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * A semaphore is a thread-synchronization construct
 *  for controlling thread access to a common resource.
 * It's often implemented as a protected variable whose
 *  value is incremented by an acquire operation and
 *  decremented by a release operation.
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        final Pool pool = new Pool();
        Runnable r = new Runnable() {
            @Override
            public void run() {

                String name = Thread.currentThread().getName();
                try {
                    while (true) {
                        String item;
                        System.out.printf("%s acquiring %s%n", name, item = pool.getItem());
                        Thread.sleep(200+(int)(Math.random()*100));
                        System.out.printf("%s putting back %s%n", name, item);
                        pool.putItem(item);
                    }
                } catch (InterruptedException ie) {
                    System.out.printf("%s interrupted%n", name);
                }
            }
        };

        ExecutorService[] executors = new ExecutorService[Pool.MAX_AVAILABLE+1];
        for (int i = 0; i < executors.length; i++) {
            executors[i] = Executors.newSingleThreadExecutor();
            executors[i].execute(r);
        }
    }
}