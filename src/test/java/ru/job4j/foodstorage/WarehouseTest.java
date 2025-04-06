package ru.job4j.foodstorage;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WarehouseTest {
    @Test
    public void whenFoodExpiresLessThan25PercentThenAccepted() {
        FoodFresh foodFresh = new FoodFresh();
        Warehouse warehouse = new Warehouse(foodFresh);

        Food food = new Food("Milk", LocalDate.now().plusDays(10), LocalDate.now().minusDays(1), 100, 0);
        assertTrue(warehouse.accept(food));
    }

    @Test
    public void whenFoodExpiresMoreThan25PercentThenNotAccepted() {
        FoodFresh foodFresh = new FoodFresh();
        Warehouse warehouse = new Warehouse(foodFresh);

        Food food = new Food("Milk", LocalDate.now().plusDays(5), LocalDate.now().minusDays(5), 100, 0);
        assertFalse(warehouse.accept(food));
    }
}