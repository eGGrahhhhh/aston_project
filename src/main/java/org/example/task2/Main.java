package org.example.task2;

public class Main {
    public static void main(String[] args) {
        CalculateFigures circle = new Circle(5, "синий", "черный");
        CalculateFigures rectangle = new Rectangle(4, 6, "зеленый", "черный");
        CalculateFigures triangle = new Triangle(3, 4, 5, "желтый", "черный");

        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }

    private static void printShapeInfo(CalculateFigures calculateFigures) {
        System.out.println("Периметр: " + calculateFigures.calculatePerimeter());
        System.out.println("Площадь: " + calculateFigures.calculateArea());
        System.out.println("Цвет заливки: " + calculateFigures.getColor());
        System.out.println("Цвет границы: " + calculateFigures.getBorderColor());
        System.out.println();
    }
}
