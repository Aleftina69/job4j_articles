package ru.job4j.parking;

public class SimpleParking implements Parking {

    private final int maxPlaces;

    public SimpleParking(int maxPlaces) {
        this.maxPlaces = maxPlaces;
    }

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

    public int getMaxPlaces() {
        return maxPlaces;
    }
}
