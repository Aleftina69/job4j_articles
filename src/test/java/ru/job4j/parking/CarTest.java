package ru.job4j.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void whenCreateCarThenHasCorrectNumber() {
        Vehicle car = new Car("1", 1);
        assertEquals("1", car.getNumber());
    }

    @Test
    void whenCreateCarThenHasCapacityOne() {
        Vehicle car = new Car("1", 1);
        assertEquals(1, car.getCapacity());
    }
}