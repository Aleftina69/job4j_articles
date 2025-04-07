package ru.job4j.ood.isp;

public interface Vehicle {
    void drive();

    void fly();

    void sail();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car...");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Cars can't fly");
    }

    @Override
    public void sail() {
        throw new UnsupportedOperationException("Cars can't sail");
    }
}

/*
Причина нарушения: класс Car реализует интерфейс Vehicle,
но не использует методы fly() и sail(), что приводит к ненужным исключениям.
 */
