import org.example.lesson_14.Lesson_14_junit_5.Factorial;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JunitTest {


    @BeforeAll
    static void setUp() {
        System.out.println("Выполняется тестирование Факториала на Junit");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Оконценно тестирование Факториала на Junit");
    }

    @DisplayName("Вычисление факториала положительных чисел и нуля")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @ParameterizedTest
    void factorialPositiveTest(int value) {
        int[] expectedResults = {1, 1, 2, 6, 24, 120};
        assertEquals(expectedResults[value], Factorial.getFactorial(value));
    }


    @DisplayName("Вычисление факториала отрицательных чисел")
    @ValueSource(ints = {-1, -2, -3, -4, -5})
    @ParameterizedTest
    void factorialNegativeTest(int value) {
        assertThrows(IllegalArgumentException.class, () -> Factorial.getFactorial(value));
    }
}
