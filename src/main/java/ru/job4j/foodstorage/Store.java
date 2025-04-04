package ru.job4j.foodstorage;

import java.util.List;

public interface Store {
    void addFood(Food food);
    void removeFood(Food food);
    List<Food> getFoods();
}
