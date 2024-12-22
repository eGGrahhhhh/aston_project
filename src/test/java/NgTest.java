import org.example.lesson_14.Lesson_14_testng.Factorial;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class NgTest {

    @BeforeClass
    public void setUp() {
        System.out.println("Выполняется тестирование Факториала на TestNG");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Оконценно тестирование Факториала на TestNG");
    }


    @DataProvider(name = "positive_data")
    public Object[][] testPositiveDataInput() {
        return new Object[][]{{0}, {1}, {2}, {3}, {4}, {5}};
    }

    @DataProvider(name = "negative_data")
    public Object[][] testNgativeDataInput() {
        return new Object[][]{{-1}, {-2}, {-3}, {-4}, {-5}};
    }

    @Test(description = "Вычисление факториала положительных чисел и нуля", dataProvider = "positive_data")
    public void factorialPositiveTest(int value) {
        int[] expectedResults = {1, 1, 2, 6, 24, 120};
        Assert.assertEquals(expectedResults[value], Factorial.getFactorial(value));
    }

    @Test(description = "Вычисление факториала отрицательных чисел", dataProvider = "negative_data",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "На вход применяется положительное число")
    public void factorialNegativeTest(int value) {
        Factorial.getFactorial(value);


    }
}