package ru.job4j.foodstorage;

import java.time.LocalDate;

public class FoodFresh {

    private LocalDate currentDate = LocalDate.now();

    public double calculateProcentage(Food food) {
        long totalTime = food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay();
        long elapsedTime = currentDate.toEpochDay() - food.getCreateDate().toEpochDay();
        return ((double) elapsedTime / totalTime) * 100;
    }

    public void setCurrentDate(LocalDate date) {
        this.currentDate = date;
    }

}
