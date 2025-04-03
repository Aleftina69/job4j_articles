package ru.job4j.ood.lsp;

class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width); // Нарушение инварианта
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height); // Нарушение инварианта
    }
}

class Main1 {
    public static void main(String[] args) {
        Rectangle rectangle = new Square(5);
        rectangle.setWidth(10);
        System.out.println(rectangle.getArea());
    }
}
/*
Класс Square нарушает инварианты класса Rectangle,
изменяя ширину и высоту одновременно. Это приводит
к неправильному поведению
при использовании экземпляра Square как Rectangle
 */