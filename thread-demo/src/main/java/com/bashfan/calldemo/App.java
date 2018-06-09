package com.bashfan.calldemo;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Random random = new Random();
                int seconds = random.nextInt(4000);
                if (seconds > 2000) {
                    throw new IOException("wow");
                }
                System.out.println("started");

                Thread.sleep(seconds);
                System.out.println("finished");
                return seconds;
            }
        });

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("sleept " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
