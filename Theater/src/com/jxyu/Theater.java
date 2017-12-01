package com.jxyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theater {
    private final String name;
    private List<Seat> seats = new ArrayList<>();

    public Theater(String name, int rows, int seatsPerRow) {
        this.name = name;
        int lastRow = 'A' + (rows-1);
        for (char row='A'; row<=lastRow;row++ ){
            for (int seatNumber=1; seatNumber<=seatsPerRow; seatNumber++){
                seats.add(new Seat(row + String.format("%02d", seatNumber)));
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requiredSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requiredSeat, null);

        if (foundSeat>=0){
            System.out.println("seat is found");
            if(seats.get(foundSeat).reserve()) {
                System.out.println("reservation " + seats.get(foundSeat).getSeatNumber() + " is done");
                return true;
            } else {
                System.out.println("seat is taken");
                return false;
            }
        }else{
            System.out.println("there is no such seat");
            return false;
        }
    }
}

class Seat implements Comparable<Seat> {
    private final String seatNumber;
    private boolean reserved = false;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public int compareTo(Seat seat) {
        return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    }

    public boolean reserve(){
        if(!this.reserved) {
            this.reserved = true;
            System.out.println("seat" + seatNumber + "reserved");
            return true;
        }else{
            return false;
        }
    }

    public boolean cancel(){
        if (this.reserved) {
            this.reserved = false;
            System.out.println("reservation" + seatNumber + "is cancelled");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", reserved=" + reserved +
                '}';
    }
}
