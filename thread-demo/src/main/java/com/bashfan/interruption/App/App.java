package com.bashfan.interruption.App;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1E8; i++) {
                    Math.sin(random.nextDouble());

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interrupted");
                        break;
                    }

//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        break;
//                    }
                }
            }
        });
        System.out.println("started");
        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finished");
    }
}
