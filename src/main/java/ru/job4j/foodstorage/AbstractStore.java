package ru.job4j.foodstorage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected List<Food> foods = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void removeFood(Food food) {
        foods.remove(food);
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    public abstract String getName();
}
