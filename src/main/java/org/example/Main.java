package org.example;

public class Main {
    public static void main(String[] args) {

        printThreeWords(); //Задание 1
        checkSumSign(); //Задание 2
        printColor(); //Задание 3
        compareNumbers(); //Задание 4
        sumCheck(1, 11); //Задание 5
        positiveOrNegativeNumber(1); //Задание 6
        positiveOrNegativeNumber2(1); //Задание 7
        printText("some text", 3); //Задание 8

    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 2, b = 3;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительна");
        } else {
            System.out.println("Сумма отрицательна");
        }
    }

    public static void printColor() {
        int value = -1;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (0 < value && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 1, b = 6;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean sumCheck(int a, int b) {
        int sum = a + b;
        if (sum > 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void positiveOrNegativeNumber(int a) {
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean positiveOrNegativeNumber2(int a) {
        if (a >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void printText(String str,int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }
}