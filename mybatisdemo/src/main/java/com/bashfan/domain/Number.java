package com.bashfan.domain;

public class Number {
    private int id;
    private int number;

    public Number(int id, int number) {
        this.id = id;
        this.number = number;
    }

    public Number() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
