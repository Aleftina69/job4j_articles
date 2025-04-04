package ru.job4j.foodstorage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrashTest {
    private Trash trash;
    private Food food;

    @BeforeEach
    void setUp() {
        trash = new Trash();
        food = new Food("Old Bread", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 0, 0);
    }

    @Test
    void testAddFood() {
        trash.addFood(food);
        assertTrue(trash.getFoods().contains(food));
    }

    @Test
    void testGetName() {
        assertEquals("Trash", trash.getName());
    }
}
