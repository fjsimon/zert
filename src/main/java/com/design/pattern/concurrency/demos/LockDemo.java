package com.design.pattern.concurrency.demos;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        final ReentrantLock reentrantLock = new ReentrantLock();

        class Worker implements Runnable {

            private  String name;

            Worker(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    if(reentrantLock.isHeldByCurrentThread()){
                        System.out.printf("Thread %s has entered its critical section.%n", name);
                        System.out.printf("Thread %s is performing work for 2 seconds.%n", name);

                        try {
                            Thread.sleep(2000);
                        } catch(InterruptedException ie){
                            ie.printStackTrace();
                        }

                        System.out.printf("Thread %s has finished working.%n", name);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }

        }

        executorService.execute(new Worker("A"));
        executorService.execute(new Worker("B"));

        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch(InterruptedException ie){
            ie.printStackTrace();
        }

        executorService.shutdownNow();
    }
}
