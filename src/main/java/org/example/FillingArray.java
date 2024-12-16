package org.example;

import java.util.Scanner;

public class FillingArray {
    public static void fillingArray(String[][] array) throws MyArraySizeException, MyArrayDataException {


        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4");
        }

        int summ = 0;
        boolean isOnlyDigits = true;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                try {
                    summ += Integer.parseInt(array[row][col]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В массиве должны быть только цифры, вы ввели: '"
                            + array[row][col] + "',в ячейке: " + (row + 1) + " " + (col + 1));
                }
            }
        }


        System.out.println("Сумма значений = " + summ);


    }
}

