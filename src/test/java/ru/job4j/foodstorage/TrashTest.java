package ru.job4j.foodstorage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TrashTest {

    @Test
    public void whenFoodExpiresMoreThan100PercentThenAccepted() {
        FoodFresh foodFresh = new FoodFresh();
        Trash trash = new Trash(foodFresh);

        Food food = new Food("Cheese", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 120, 0);
        assertTrue(trash.accept(food));
    }

    @Test
    public void whenFoodExpiresLessThan100PercentThenNotAccepted() {
        FoodFresh foodFresh = new FoodFresh();
        Trash trash = new Trash(foodFresh);

        Food food = new Food("Yogurt", LocalDate.now().plusDays(5), LocalDate.now().minusDays(1), 30, 0);
        assertFalse(trash.accept(food));
    }
}