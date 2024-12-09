package org.example.task2;


public class Circle implements CalculateFigures {
    private double radius;
    private String color;
    private String borderColor;

    public Circle(double radius, String color, String borderColor) {
        this.radius = radius;
        this.color = color;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
