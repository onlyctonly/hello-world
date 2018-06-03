package com.bashfan.multithread;

class Runner extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+ " ## "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Runner r1 = new Runner();
        r1.start();

        Runner r2 = new Runner();
        r2.start();
    }
}
