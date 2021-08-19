package com.design.pattern.concurrency.demos;

import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class MyConsumer<T> {

    private BlockingQueue<T> queue;

    public MyConsumer(BlockingQueue<T> queue) {

        this.queue = queue;
    }

    /**
     * Retrieves an object from the head of the queue and passes it to the
     * consumer
     *
     * @param consumer
     *            Contains the logic on what to do with the retrieved object
     */
    public void consume(Consumer<T> consumer) {

        try {
            consumer.accept(queue.take());

            // Simulate a long running process
            MILLISECONDS.sleep(1250);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}