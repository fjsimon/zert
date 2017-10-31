package com.oca.exam.extra.features;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.lang.System.out;

public class ProducerConsumer {

    private static final int MSG_NBR = 10;

    private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        new ProducerConsumer().startEngine();
    }

    public void startEngine() {

        startProducer();
        startConsumer();
    }

    // Producer thread
    private void startProducer() {

        final MyProducer<String> myProducer = new MyProducer<>(queue);
        final Supplier<String> supplier = () -> "Hello World";
        new Thread(() -> {
            for (int i = 0; i < MSG_NBR; i++) {
                myProducer.produce(supplier);
            }
        }).start();
    }

    // Consumer thread
    private void startConsumer() {

        final MyConsumer<String> myConsumer = new MyConsumer<>(queue);
        final Consumer<String> consumer = (s) -> out.println("Consumed message: " + s);
        new Thread(() -> {
            for (int i = 0; i < MSG_NBR; i++)
                myConsumer.consume(consumer);
        }).start();
    }
}