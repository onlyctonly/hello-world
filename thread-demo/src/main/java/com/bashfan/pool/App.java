package com.bashfan.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
    private int id;
    Processor(int id){
        this.id=id;
    }
    public void run() {
        System.out.println("start " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish "+ id);
    }
}

public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i <4 ; i++) {
            executorService.submit(new Processor(i));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("all done!");
//        all done! appears first before finish 0,1 and start 2,3, finish2,3

    }
}
