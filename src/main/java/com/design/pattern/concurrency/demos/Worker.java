package com.design.pattern.concurrency.demos;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    private final static int N = 5;

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal){
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run(){
        try{

            String name = Thread.currentThread().getName();
            startSignal.await();
            for(int i = 0; i < N; i++) {
                System.out.printf("thread %s is working%n", name);
                try{
                    Thread.sleep((int)(Math.random()*300));
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
            System.out.printf("thread %s finishing%n", name);
            doneSignal.countDown();

        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

}
