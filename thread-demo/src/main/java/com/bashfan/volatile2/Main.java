package com.bashfan.volatile2;

import java.util.Scanner;

class Runner extends Thread {
    private volatile boolean running = true;

    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " ## " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!running) {
                break;
            }
        }


    }

    public void shutdown() {
        running = false;
    }
}

public class Main {
    public static void main(String[] args) {
        Runner r1 = new Runner();
        r1.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        r1.shutdown();

    }
}
