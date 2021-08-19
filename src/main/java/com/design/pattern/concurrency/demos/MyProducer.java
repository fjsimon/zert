package com.design.pattern.concurrency.demos;

import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class MyProducer<T> {

    private BlockingQueue<T> queue;

    public MyProducer(BlockingQueue<T> queue) {

        this.queue = queue;
    }

    /**
     * Insert the supplied object in the queue
     *
     * @param supplier
     *            Is responsible for supplying the object that will be put
     *            in the queue
     */
    public void produce(Supplier<T> supplier) {

        final T msg = supplier.get();
        try {
            queue.put(msg);
            out.println("Added message: " + msg);

            // Simulate a long running process
            MILLISECONDS.sleep(900);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}