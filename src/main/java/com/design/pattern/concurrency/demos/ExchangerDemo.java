package com.design.pattern.concurrency.demos;

import java.util.concurrent.Exchanger;

/**
 * An exchanger (also known as a rendezvous) is a thread-synchronization
 *  construct that lets a pair of threads exchange data items.
 *
 * An exchanger is similar to a cyclic barrier whose count is set to 2
 *  but also supports exchange of data when both threads reach the barrier
 */
public class ExchangerDemo {

    static Exchanger<DataBuffer> exchanger = new Exchanger<DataBuffer>();
    static DataBuffer initialEmptyBuffer = new DataBuffer();
    static DataBuffer initialFullBuffer = new DataBuffer("ITEM");

    public static void main(String[] args){

        class FillingLoop implements Runnable {

            int count = 0;

            @Override
            public void run() {
                DataBuffer currentBuffer = initialEmptyBuffer;

                try{
                    while(true){
                        addToBuffer(currentBuffer);
                        if(currentBuffer.isFull()){
                            System.out.printf("filling loop thread wants to exchange");
                            currentBuffer = exchanger.exchange(currentBuffer);
                            System.out.println("filling loop thread observes an exchange");
                        }
                    }
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }

            private void addToBuffer(DataBuffer buffer) {

                String item = "NewItem"+count++;
                System.out.printf("Adding %s%n", item);
                buffer.add(item);
            }
        }

        class EmptyingLoop implements Runnable {

            @Override
            public void run() {
                DataBuffer currentBuffer = initialFullBuffer;

                try {

                    while (true) {

                        takeFromBuffer(currentBuffer);
                        if(currentBuffer.isEmpty()){
                            System.out.println("emptying loop thread wants to exchange");
                            currentBuffer = exchanger.exchange(currentBuffer);
                            System.out.println("emptying loop thread observes an exchange");
                        }
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

            private void takeFromBuffer(DataBuffer buffer) {

                System.out.printf("Taking '%s%n", buffer.remove());
            }
        }

        new Thread(new EmptyingLoop()).start();
        new Thread(new FillingLoop()).start();
    }
}
