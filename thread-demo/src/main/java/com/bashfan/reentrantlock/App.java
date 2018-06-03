package com.bashfan.reentrantlock;

public class App {
    private static         Runner runner = new Runner();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                runner.firstthread();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                runner.secondthread();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runner.finished();
    }
}
