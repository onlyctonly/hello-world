package com.jxyu;

public class BankAccount {
    private String firstname;
    private String lastname;
    private double balance;

    public BankAccount(String firstname, String lastname, Double balance) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.balance = balance;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public double deposit(Double amount) {
        return this.balance += amount;
    }

    public double withdraw(Double amount) {
        return this.balance -= amount;
    }
}
