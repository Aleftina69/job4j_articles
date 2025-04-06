package ru.job4j.foodstorage;

public class Trash extends AbstractStore {
    private final FoodFresh foodFresh;

    public Trash(FoodFresh foodFresh) {
        this.foodFresh = foodFresh;
    }

    @Override
    public boolean accept(Food food) {
        double used = foodFresh.calculateProcentage(food);
        return used >= 100;
    }

    @Override
    public String getName() {
        return "Trash";
    }
}
