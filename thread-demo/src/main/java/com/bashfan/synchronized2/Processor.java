package com.bashfan.synchronized2;

public class Processor {
    public void producer() {
        synchronized (this) {
            System.out.println("start");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i am producer again");
        }

    }

    public void consumer() {
        synchronized (this) {
            System.out.println("i am consumer");
            notify(); // below will still run
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
