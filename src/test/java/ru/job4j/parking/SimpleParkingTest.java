package ru.job4j.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleParkingTest {

    @Test
    void whenCreateParkingThenMaxPlacesSet() {
        SimpleParking parking = new SimpleParking(10);
        assertEquals(10, parking.getMaxPlaces());
    }

    @Test
    void whenParkCarThenIsParked() {
        SimpleParking parking = new SimpleParking(1);
        Vehicle car = new Car("A1", 1);

        boolean parked = parking.park(car);
        assertTrue(parked);
        assertTrue(parking.isParked(car));
    }

    @Test
    void whenParkCarInFullParkingThenFail() {
        SimpleParking parking = new SimpleParking(1);
        Vehicle car1 = new Car("A1", 1);
        Vehicle car2 = new Car("B1", 1);

        parking.park(car1);
        boolean parked = parking.park(car2);
        assertFalse(parked);
    }

    @Test
    void whenLeaveCarThenIsNotParked() {
        SimpleParking parking = new SimpleParking(1);
        Vehicle car = new Car("A1", 1);

        parking.park(car);
        boolean isLeave = parking.leave(car);
        assertTrue(isLeave);
        assertFalse(parking.isParked(car));
    }

    @Test
    void whenLeaveCarNotInParkingThenFail() {
        SimpleParking parking = new SimpleParking(1);
        Vehicle car = new Car("A1", 1);

        boolean isLeave = parking.leave(car);
        assertFalse(isLeave);
    }
}