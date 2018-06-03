package com.bashfan.reentrantlock2;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private Account acc1 = new Account();
    private Account acc2 = new Account();
    private Random random = new Random();
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void firstThread() {
        for (int i = 0; i < 10000; i++) {
            reentrantLock.lock();
            Account.transfer(acc1,acc2,random.nextInt(10));
            reentrantLock.unlock();
        }
    }

    public void secondThread() {
        for (int i = 0; i < 10000; i++) {
            reentrantLock.lock();
            Account.transfer(acc2,acc1,random.nextInt(10));
            reentrantLock.unlock();
        }
    }

    public void finished() {
        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println((acc1.getBalance()+acc2.getBalance()));
    }
}
