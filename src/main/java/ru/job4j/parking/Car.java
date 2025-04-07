package ru.job4j.parking;

public class Car implements Vehicle {
    private final String number;
    private final int capacity;

    public Car(String number, int capacity) {
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
