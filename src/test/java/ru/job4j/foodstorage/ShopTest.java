package ru.job4j.foodstorage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {

    @Test
    public void whenFoodExpiresBetween25And75PercentThenAccepted() {
        FoodFresh foodFresh = new FoodFresh();
        Shop shop = new Shop(foodFresh);

        Food food = new Food("Bread", LocalDate.now().plusDays(5), LocalDate.now().minusDays(3), 50, 0);
        assertTrue(shop.accept(food));
    }

    @Test
    public void whenFoodExpiresMoreThan75PercentThenDiscountedAndAccepted() {
        FoodFresh foodFresh = new FoodFresh();
        Shop shop = new Shop(foodFresh);

        Food food = new Food("Juice", LocalDate.now().plusDays(2), LocalDate.now().minusDays(8), 40, 20);
        assertTrue(shop.accept(food));
        assertEquals(32.0, food.getPrice(), 0.01); // Проверка, что цена была снижена на 20%
    }
}