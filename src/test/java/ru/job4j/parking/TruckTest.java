package ru.job4j.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    @Test
    void whenCreateTruckThenHasCorrectNumber() {
        Vehicle truck = new Truck("1", 2);
        assertEquals("1", truck.getNumber());
    }

    @Test
    void whenCreateTruckThenHasCorrectCapacity() {
        Vehicle truck = new Truck("1", 2);
        assertEquals(2, truck.getCapacity());
    }
}