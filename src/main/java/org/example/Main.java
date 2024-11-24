package org.example;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        System.out.println();
        printThreeWords();

        System.out.println();
        checkSumSign();

        System.out.println();
        printColor();

        System.out.println();
        compareNumbers();

        System.out.println();
        System.out.println(sumCheck(1, 11));

        System.out.println();
        positiveOrNegativeNumber(1);

        System.out.println();
        System.out.println(positiveOrNegativeNumber2(1));

        System.out.println();
        printText("some text", 3);

        System.out.println();
        System.out.println(leapYear(0));

        System.out.println();
        swapper();

        System.out.println();
        fillArr();

        System.out.println();
        multiplicationArr();

        System.out.println();
        multidimensionalArr();

        System.out.println();
        arrGenerate(9, 1);

    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int value1 = 2, value2 = 3;
        int sum = value1 + value2;
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
        int value1 = 1, value2 = 6;
        if (value1 >= value2) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean sumCheck(int value1, int value2) {
        int sum = value1 + value2;
        if (sum > 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void positiveOrNegativeNumber(int value) {
        if (value >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean positiveOrNegativeNumber2(int value) {
        if (value >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void printText(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    public static boolean leapYear(int value) {
        if (value % 4 == 0) {
            if (value % 400 == 0) {
                return true;
            } else if (value % 100 == 0) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static void swapper() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
                default:
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArr() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void multiplicationArr() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void multidimensionalArr() {
        int[][] arr = new int[5][5];
        for (int col = 0; col < arr.length; col++) {
            for (int row = 0; row < arr.length; row++) {
                arr[col][col] = 1;
                arr[col][arr.length - 1 - col] = 1;
            }
            System.out.println(Arrays.toString(arr[col]));
        }
    }

    public static int[] arrGenerate(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}