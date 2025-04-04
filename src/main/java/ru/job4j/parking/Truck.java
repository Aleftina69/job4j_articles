package ru.job4j.parking;

public class Truck implements Vehicle {
    private final String number;
    private final int capacity;


    public Truck(String number, int capacity) {
        if (capacity <= 1) {
            throw new IllegalArgumentException("size must be > 1");
        }
        this.number = number;
        this.capacity = capacity;

    }

    @Override
    public int getCapacity() {
       return capacity;
    }

    @Override
    public String getNumber() {
        return number;
    }
}
