package ru.job4j.foodstorage;

import java.util.List;

public interface Store {
    void addFood(Food food);

    boolean accept(Food food);

    void removeFood(Food food);

    List<Food> getFoods();
}
