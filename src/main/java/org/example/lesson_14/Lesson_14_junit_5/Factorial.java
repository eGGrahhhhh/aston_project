package org.example.lesson_14.Lesson_14_junit_5;

public class Factorial {

    public static int getFactorial(int factorial) {
        int result = 1;
        if (factorial < 0) {
            throw new IllegalArgumentException("На вход применяется положительное число");
        } else {
            for (int i = 1; i <= factorial; i++) {
                result *= i;
            }
            return result;
        }
    }
}
