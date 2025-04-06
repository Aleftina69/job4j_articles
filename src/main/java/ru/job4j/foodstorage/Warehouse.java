package ru.job4j.foodstorage;

public class Warehouse extends AbstractStore {
    private final FoodFresh foodFresh;

    public Warehouse(FoodFresh foodFresh) {
        this.foodFresh = foodFresh;
    }

    @Override
    public boolean accept(Food food) {
        double used = foodFresh.calculateProcentage(food);
        return used <= 25;
    }

    @Override
    public String getName() {
        return "Warehouse";
    }
}
