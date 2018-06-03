package com.bashfan.reentrantlock2;

public class Account {
    private int balance =10000;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance+=amount;
    }

    public void withdrawal(int amount) {
        balance-=amount;
    }

    public static void transfer(Account fromAccount, Account toAccount, int amount) {
        fromAccount.withdrawal(amount);
        toAccount.deposit(amount);
    }
}
