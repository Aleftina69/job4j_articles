package ru.job4j.foodstorage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    private Shop shop;
    private Food food;

    @BeforeEach
    void setUp() {
        shop = new Shop();
        food = new Food("Banana", LocalDate.now().plusDays(5), LocalDate.now(), 50, 0);
    }

    @Test
    void testAddFood() {
        shop.addFood(food);
        assertTrue(shop.getFoods().contains(food));
    }

    @Test
    void testGetName() {
        assertEquals("Shop", shop.getName());
    }
}