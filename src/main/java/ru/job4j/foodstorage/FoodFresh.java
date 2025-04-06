package ru.job4j.foodstorage;

import java.time.LocalDate;

public class FoodFresh {

    private LocalDate currentDate = LocalDate.now();  // можно задавать эту дату для тестов


    // Метод для расчета процента израсходованного срока годности
    public double calculateProcentage(Food food) {
        long totalTime = food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay();
        long elapsedTime = currentDate.toEpochDay() - food.getCreateDate().toEpochDay(); // Используем currentDate
        return ((double) elapsedTime / totalTime) * 100;
    }

    // Метод для изменения текущей даты для тестов
    public void setCurrentDate(LocalDate date) {
        this.currentDate = date;
    }

}
