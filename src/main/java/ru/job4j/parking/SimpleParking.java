package ru.job4j.parking;

public class SimpleParking implements Parking {
    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean leave(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean isParked(Vehicle vehicle) {
        return false;
    }
}
