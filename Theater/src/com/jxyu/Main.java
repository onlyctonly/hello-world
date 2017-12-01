package com.jxyu;

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Olympia", 5,12);
        theater.getSeats().forEach(System.out::println);

        theater.reserveSeat("a02");
        theater.reserveSeat("a02");
        theater.reserveSeat("a13");
    }
}
