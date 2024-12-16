package org.example;

public class Main {
    public static void main(String[] args) {

        String[][] myArray1 = {
                {"0", "1", "2", "3"},
                {"44", "55", "66", "77"},
                {"888", "999", "000", "123"},
                {"456", "789", "000", "1111"}
        };

        String[][] myArray2 = {
                {"0", "1", "-2", "-3"},
                {"44", "55", "-66", "77"},
                {"888", "-999", "000", "123"},
                {"456", "789", "000", "1111"}
        };

        String[][] myArray3 = {
                {"0", "1", "2", "3"},
                {"44", "55", "qqqqqqq", "77"},
                {"888", "999", "000", "123"},
                {"456", "789", "000", "1111"}
        };

        String[][] myArray4 = {
                {"0", "1", "2", "3"},
                {"44", "55", "qqqqqqq", "77"},
                {"888", "999", "000", "123"}
        };

        try {
            FillingArray.fillingArray(myArray1);

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            FillingArray.fillingArray(myArray2);

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            FillingArray.fillingArray(myArray3);

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            FillingArray.fillingArray(myArray4);

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}