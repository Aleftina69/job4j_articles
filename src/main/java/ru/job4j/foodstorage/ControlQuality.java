package ru.job4j.foodstorage;

import java.util.List;

public class ControlQuality {
    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }
    public void distribute(Food food) {
        long shelfLifeRemaining = food.getShelfLifeRemaining();
        long totalShelfLife = food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay();
        double percentageUsed = ((totalShelfLife - shelfLifeRemaining) / (double) totalShelfLife) * 100;

        if (percentageUsed < 25) {
            addToStore(food, Warehouse.class);
        } else if (percentageUsed < 75) {
            addToStore(food, Shop.class);
        } else if (percentageUsed < 100) {
            food = new Food(food.getName(), food.getExpiryDate(), food.getCreateDate(), food.getDiscountedPrice(), food.getDiscount());
            addToStore(food, Shop.class);
        } else {
            addToStore(food, Trash.class);
        }
    }

    private void addToStore(Food food, Class<? extends AbstractStore> storeClass) {
        for (Store store : stores) {
            if (store.getClass().equals(storeClass)) {
                store.addFood(food);
                return;
            }
        }
    }
}
