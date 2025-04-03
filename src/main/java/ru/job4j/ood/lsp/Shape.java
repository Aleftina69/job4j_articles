package ru.job4j.ood.lsp;

interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Square1 implements Shape {
    private double side;

    public Square1(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return (base * height) / 2;
    }
}

class Main2 {
    public static void main(String[] args) {
        Shape shape = new Triangle(10, 5);
        System.out.println("Area: " + shape.area());
    }
}

/*
 Если класс Triangle неправильно реализует метод area(),
 это может привести к неправильному поведению при использовании
 экземпляра Triangle как Shape. Это нарушает принцип подстановки,
 поскольку поведение не соответствует ожиданиям, связанным с интерфейсом Shape
 */
