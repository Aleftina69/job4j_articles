package ru.job4j.parking;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        }
        if (o != null && this != o) {
            try {
                Vehicle that = (Vehicle) o;
                result = Objects.equals(this.getNumber(), that.getNumber());
            } catch (ClassCastException e) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
