package com.bashfan.atomic;

public class Main {

    private int count = 0;



    public static void main(String[] args) {
        Main main = new Main();
        main.dowork();
    }

    private void dowork() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <10000 ; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <10000 ; i++) {
                    increment();
                }
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
        System.out.println(count);
    }

    private synchronized void increment() {
        count++;
    }
}
