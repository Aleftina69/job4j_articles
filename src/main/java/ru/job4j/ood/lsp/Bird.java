package ru.job4j.ood.lsp;

class Bird {
    public void fly() {
        System.out.println("I can fly!");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches cannot fly");
    }
}

class Main {
    public static void main(String[] args) {
        Bird bird = new Ostrich();
        bird.fly();
    }
}
/*
 Класс Ostrich переопределяет метод fly, чтобы бросить исключение,
 что нарушает ожидания, связанные с использованием базового класса Bird.
 Это приводит к тому, что экземпляр Ostrich не может быть использован
 вместо Bird без изменения поведения.
 */