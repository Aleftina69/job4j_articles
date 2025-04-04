package ru.job4j.parking;

public interface ParkingSpace {
    boolean canFit(Vehicle vehicle);

    boolean isOccupied();

    void park(Vehicle vehicle);

    void leave();
}
