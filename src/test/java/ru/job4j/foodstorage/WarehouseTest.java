package ru.job4j.foodstorage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    private Warehouse warehouse;
    private Food food;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse();
        food = new Food("Apple", LocalDate.now().plusDays(10), LocalDate.now(), 100, 0);
    }

    @Test
    void testAddFood() {
        warehouse.addFood(food);
        assertTrue(warehouse.getFoods().contains(food));
    }

    @Test
    void testGetName() {
        assertEquals("Warehouse", warehouse.getName());
    }
}