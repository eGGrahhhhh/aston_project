package org.example.task2;

public class Rectangle implements CalculateFigures {
    private double value1;
    private double value2;
    private String color;
    private String borderColor;

    public Rectangle(double value1, double value2, String color, String borderColor) {
        this.value1 = value1;
        this.value2 = value2;
        this.color = color;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return (value1 + value2) * 2;
    }

    @Override
    public double calculateArea() {
        return value1 * value2;
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
