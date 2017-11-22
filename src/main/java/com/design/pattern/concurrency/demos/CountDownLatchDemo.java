package com.design.pattern.concurrency.demos;

import java.util.concurrent.CountDownLatch;

/**
 *  A countdown latch is a thread-synchronization construct
 *      that causes one or more threads to wait until a set of
 *      operations being performed by other threads finishes.
 *
 *  It consists of a count and "cause a thread to wait until
 *      the count reaches zero" and "decrement the count"
 *      operations.
 */
public class CountDownLatchDemo {

    final static int N = 3;

    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);
        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();
        System.out.println("About to let threads proceed");
        startSignal.countDown(); // let all threads proceed
        System.out.println("doing work");
        System.out.println("waiting for threads to finish");
        doneSignal.await(); // wait for all threads to finish
        System.out.println("main thread terminating");
    }

}
