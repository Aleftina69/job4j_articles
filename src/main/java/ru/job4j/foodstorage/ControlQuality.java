package ru.job4j.foodstorage;

import java.util.List;

public class ControlQuality {
    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void addToStore(Food food) {
        for (Store store : stores) {
            if (store.accept(food)) {
                store.addFood(food);
                break;
            }
        }
    }

    public void redistribute(List<Food> foods) {
        for (Food food : foods) {
            addToStore(food);
        }
    }
}
