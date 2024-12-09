package org.example.task2;

public class Triangle implements CalculateFigures {
    private double value1;
    private double value2;
    private double value3;
    private String color;
    private String borderColor;

    public Triangle(double value1, double value2, double value3, String color, String borderColor) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.color = color;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return value1 + value2 + value3;
    }

    @Override
    public double calculateArea() {
        double perimeterTriangle = calculatePerimeter();
        return Math.sqrt(perimeterTriangle * (perimeterTriangle - value1) * (perimeterTriangle - value2) * (perimeterTriangle - value3));
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
