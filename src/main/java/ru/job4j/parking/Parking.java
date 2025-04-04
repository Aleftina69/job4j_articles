package ru.job4j.parking;

public interface Parking {
    boolean park(Vehicle vehicle);

    boolean leave(Vehicle vehicle);

    boolean isParked(Vehicle vehicle);
}
