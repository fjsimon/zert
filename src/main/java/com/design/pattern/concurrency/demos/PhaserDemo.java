package com.design.pattern.concurrency.demos;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Phaser;

/**
 * A phaser is a thread-synchronization construct that's similar to a cyclic barrier in that it lets a group of
 * threads wait on a barrier and then proceed after the last thread arrives.
 * It also offers the equivalent of a barrier action. However, a phaser is more flexible.
 */
public class PhaserDemo {

    public static void main(String[] args) {

        List<Runnable> tasks = new ArrayList<>();

        tasks.add(new Runnable() {
            @Override
            public void run() {
                System.out.printf("%s running at %d%n", Thread.currentThread().getName(), System.currentTimeMillis());
            }
        });

        tasks.add(new Runnable() {
            @Override
            public void run() {
                System.out.printf("%s running at %d%n", Thread.currentThread().getName(), System.currentTimeMillis());
            }
        });

        runTasks(tasks);
    }

    private static void runTasks(List<Runnable> tasks) {

        final Phaser phaser = new Phaser(1); // "1" to register self
        // create and start threads
        for (final Runnable task: tasks) {
            phaser.register();
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(50+(int)(Math.random()*300));
                    } catch (InterruptedException ie) {
                        System.out.println("interrupted thread");
                    }
                    phaser.arriveAndAwaitAdvance(); // await all creation
                    task.run();
                }
            }.start();
        }

        // allow threads to start and deregister self
        phaser.arriveAndDeregister();
    }
}