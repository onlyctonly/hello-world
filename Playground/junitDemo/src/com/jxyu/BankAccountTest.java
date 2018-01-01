package com.jxyu;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        BankAccount ba = new BankAccount("xiangyu", "jia", 1000.00);
        double balance = ba.deposit(200.00);
        assertEquals(1200.00, balance);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        BankAccount ba = new BankAccount("xiangyu", "jia", 1000.00);
        double bal = ba.withdraw(200.00);
        assertEquals(800.00, bal);

    }

}