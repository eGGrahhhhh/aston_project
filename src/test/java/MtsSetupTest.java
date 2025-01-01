import jdk.jfr.Description;
import org.example.lesson_16.HomePage;
import org.example.lesson_16.PaymentPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsSetupTest {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    PaymentPage paymentPage;

    private static String value = "Услуги связи";
    private static String phoneNumber = "297777777";
    private static String sum = "12.34";
    private static String email = "test@mail.ru";

    static Stream<Arguments> getValues() {
        return Stream.of(
                Arguments.of(value, phoneNumber, sum, email)
        );
    }

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:/AQA_ASTON/aston_project/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        homePage = new HomePage(driver);
        paymentPage = new PaymentPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (homePage.cookieOnPage()) {
            homePage.cookieAccept();
        }
        assertTrue(homePage.atPage());
    }

    @AfterEach
    public void driverTearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    @Description("Проверка на соответствие надписям в placeholder для типа оплаты Услуги связи")
    public void checkPlaceholderTextForConnectionServices() {
        homePage.selectTypePaymentServices("Услуги связи");
        assertEquals("Номер телефона", homePage.getPhoneNumberText());
        assertEquals("Сумма", homePage.getSumText());
        assertEquals("E-mail для отправки чека", homePage.getEmailText());
    }

    @Test
    @Order(3)
    @Description("Проверка на соответствие надписям в placeholder для типа оплаты Домашний интернет")
    public void checkPlaceholderTextForHomeInternet() {
        homePage.selectTypePaymentServices("Домашний интернет");
        assertEquals("Номер абонента", homePage.getPhoneNumberText());
        assertEquals("Сумма", homePage.getSumText());
        assertEquals("E-mail для отправки чека", homePage.getEmailText());
    }

    @Test
    @Order(2)
    @Description("Проверка на соответствие надписям в placeholder для типа оплаты Рассрочка")
    public void checkPlaceholderTextForScoreInstalment() {
        homePage.selectTypePaymentServices("Рассрочка");
        assertEquals("Номер счета на 44", homePage.getScoreText());
        assertEquals("Сумма", homePage.getSumText());
        assertEquals("E-mail для отправки чека", homePage.getEmailText());
    }

    @Test
    @Order(4)
    @Description("Проверка на соответствие надписям в placeholder для типа оплаты Задолженность")
    public void checkPlaceholderTextForScoreArrears() {
        homePage.selectTypePaymentServices("Задолженность");
        assertEquals("Номер счета на 2073", homePage.getScoreText());
        assertEquals("Сумма", homePage.getSumText());
        assertEquals("E-mail для отправки чека", homePage.getEmailText());
    }

    @Order(5)
    @Description("Заполнение данных для типа оплаты 'Услуги связи' и проверка надписей в окне оплаты")
    @MethodSource("getValues")
    @ParameterizedTest
    public void paymentPageTest(String value, String phoneNumber, String sum, String email) {
        homePage.fillingDataPaymentServices(value, phoneNumber, sum, email);
        paymentPage.toFrame();
        assertEquals(sum + " BYN", paymentPage.getPaymentAmountText());
        assertEquals("Оплатить " + sum + " BYN", paymentPage.getPaymentAmountButtonText());
        assertEquals("Срок действия", paymentPage.getValidityPeriodText());
        assertTrue(paymentPage.getNumberInDescriptionText().contains(phoneNumber));
        assertEquals("Номер карты", paymentPage.getCartNumberText());
        assertEquals("CVC", paymentPage.getCvcNumberText());
        assertEquals("Имя держателя (как на карте)", paymentPage.getNameOwnerText());
        assertTrue(paymentPage.getIconPayment());
    }
}
