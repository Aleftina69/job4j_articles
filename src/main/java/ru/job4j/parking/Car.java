package ru.job4j.parking;

public class Car implements Vehicle {
    private final String number;

    public Car(String number) {
        this.number = number;
    }

    @Override
    public int getCapacity() {
        return 1;
    }

    @Override
    public String getNumber() {
        return number;
    }
}
