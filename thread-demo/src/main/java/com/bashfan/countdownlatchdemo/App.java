package com.bashfan.countdownlatchdemo;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
    private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        while (countDownLatch.getCount() > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("minus 1");
        }
    }
}

public class App {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(9);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i <3 ; i++) {
            executorService.submit(new Processor(countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        long end = System.currentTimeMillis();

        System.out.println("finished: " + (end-start));
    }
}
