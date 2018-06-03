package com.bashfan.blockingqueuedemo;


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
    private static Random random = new Random();
    static void producer(){
        while (true) {
            try {
                blockingQueue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static void consumer() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            if (random.nextInt(10) == 0) {
                try {
                    Integer value = blockingQueue.take();
                    System.out.println("the value is: "+ value + "; "+ "size is: " + blockingQueue.size() );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                producer();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                consumer();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
