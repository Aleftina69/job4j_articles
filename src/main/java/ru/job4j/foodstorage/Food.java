package ru.job4j.foodstorage;

import java.time.LocalDate;

public class Food {
    private String name;
    private LocalDate expiryDate;
    private LocalDate createDate;
    private double price;
    private double discount;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }
    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getDiscountedPrice() {
        return price - (price * (discount / 100));
    }

    public long getShelfLifeRemaining() {
        return expiryDate.toEpochDay() - LocalDate.now().toEpochDay();
    }

    public long getTotalShelfLife() {
        return expiryDate.toEpochDay() - createDate.toEpochDay();
    }
}
