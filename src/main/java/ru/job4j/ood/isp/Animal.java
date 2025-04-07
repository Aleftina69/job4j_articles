package ru.job4j.ood.isp;

public interface Animal {
    void eat();

    void sleep();

    void fly();
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping...");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Dogs can't fly");
    }
}
/*
Причина нарушения: класс Dog реализует метод fly(),
который не имеет смысла для этого класса, что приводит к ненужным исключениям.
 */
