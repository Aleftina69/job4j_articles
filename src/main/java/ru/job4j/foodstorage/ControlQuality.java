package ru.job4j.foodstorage;

import java.util.ArrayList;
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

    public void redistributes() {
        List<Food> allFoods = new ArrayList<>();
        for (Store store : stores) {
            allFoods.addAll(store.getFoods());
        }
        for (Store store : stores) {
            store.getFoods().clear();
        }

        for (Food food : allFoods) {
            addToStore(food);
        }
    }

    public void resort() {
        System.out.println("перераспределение продуктов");
        redistributes();
    }
}
