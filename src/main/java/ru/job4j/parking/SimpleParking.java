package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class SimpleParking implements Parking {
    private final List<Vehicle> parkVehicles = new ArrayList<>();

    private final int maxPlaces;

    public SimpleParking(int maxPlaces) {
        this.maxPlaces = maxPlaces;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean result = false;
        if (freePlaces() >= vehicle.getCapacity() && !isParked(vehicle)) {
            parkVehicles.add(vehicle);
            result = true;
        }
        return result;
    }

    @Override
    public boolean leave(Vehicle vehicle) {
        return parkVehicles.remove(vehicle);
    }

    @Override
    public boolean isParked(Vehicle vehicle) {
        return parkVehicles.contains(vehicle);
    }


    public int getMaxPlaces() {
        return maxPlaces;
    }

    public int freePlaces() {
        int used = 0;
        for (Vehicle vehicle : parkVehicles) {
            used += vehicle.getCapacity();
        }
        return maxPlaces - used;
    }
}
