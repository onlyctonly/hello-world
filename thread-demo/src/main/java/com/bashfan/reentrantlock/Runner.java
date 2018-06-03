package com.bashfan.reentrantlock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private int count =0;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void firstthread() {
        reentrantLock.lock();
        System.out.println("waiting");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("woken up");
        try {
            increment();

        }finally {
            reentrantLock.unlock();
        }

    }

    public void secondthread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.lock();
        System.out.println("press enter to continue");
        new Scanner(System.in).nextLine();
        System.out.println("enter pressed");

        condition.signal();
        try {
            increment();

        }finally {
            reentrantLock.unlock();
        }
        System.out.println("go back to first thread");
    }

    public void finished() {
        System.out.println(count);
    }
}
