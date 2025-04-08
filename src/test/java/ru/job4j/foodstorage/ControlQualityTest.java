package ru.job4j.foodstorage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ControlQualityTest {

    private static final LocalDate FIXED_DATE = LocalDate.of(2025, 4, 6);

    @Test
    public void whenFoodAcceptedInWarehouse() {
        FoodFresh foodFresh = new FoodFresh();
        Warehouse warehouse = new Warehouse(foodFresh);
        Shop shop = new Shop(foodFresh);
        Trash trash = new Trash(foodFresh);

        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        Food food = new Food("Milk", FIXED_DATE.plusDays(20), FIXED_DATE.minusDays(1), 100, 0);
        controlQuality.addToStore(food);

        assertTrue(warehouse.getFoods().contains(food));
        assertTrue(shop.getFoods().isEmpty());
        assertTrue(trash.getFoods().isEmpty());
    }

    @Test
    public void whenFoodAcceptedInShop() {
        FoodFresh foodFresh = new FoodFresh();
        Warehouse warehouse = new Warehouse(foodFresh);
        Shop shop = new Shop(foodFresh);
        Trash trash = new Trash(foodFresh);

        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));

        Food food = new Food("Bread", FIXED_DATE.plusDays(5), FIXED_DATE.minusDays(5), 50, 0);
        controlQuality.addToStore(food);

        assertTrue(shop.getFoods().contains(food));
        assertTrue(warehouse.getFoods().isEmpty());
        assertTrue(trash.getFoods().isEmpty());
    }

    @Test
    public void whenFoodAcceptedInShopWithDiscount() {
        FoodFresh foodFresh = new FoodFresh();
        Warehouse warehouse = new Warehouse(foodFresh);
        Shop shop = new Shop(foodFresh);
        Trash trash = new Trash(foodFresh);

        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));

        Food food = new Food("Juice", FIXED_DATE.plusDays(2), FIXED_DATE.minusDays(8), 40, 20);

        controlQuality.addToStore(food);

        assertTrue(shop.getFoods().contains(food));

        double expectedPrice = 40.0 * 0.8;
        assertEquals(expectedPrice, food.getPrice(), 0.01);
    }

    @Test
    public void whenFoodAcceptedInTrash() {
        FoodFresh foodFresh = new FoodFresh();
        Warehouse warehouse = new Warehouse(foodFresh);
        Shop shop = new Shop(foodFresh);
        Trash trash = new Trash(foodFresh);

        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));

        Food food = new Food("Cheese", FIXED_DATE.minusDays(1), FIXED_DATE.minusDays(10), 120, 0);
        controlQuality.addToStore(food);

        assertTrue(trash.getFoods().contains(food));
        assertTrue(warehouse.getFoods().isEmpty());
        assertTrue(shop.getFoods().isEmpty());
    }
}