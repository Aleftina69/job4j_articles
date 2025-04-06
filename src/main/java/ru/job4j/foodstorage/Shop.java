package ru.job4j.foodstorage;

public class Shop extends AbstractStore {

    private final FoodFresh foodFresh;

    public Shop(FoodFresh foodFresh) {
        this.foodFresh = foodFresh;
    }

    @Override
    public boolean accept(Food food) {
        double used = foodFresh.calculateProcentage(food);

        if (used > 75 && used <= 100) {
            food.setPrice(food.getPrice() * 0.8);
            return true;
        }

        return used >= 25 && used <= 75;
    }

    @Override
    public String getName() {
        return "Shop";
    }
}
