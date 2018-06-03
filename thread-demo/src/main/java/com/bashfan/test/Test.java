package com.bashfan.test;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            Thread.sleep(1000);
        }
    }
}
