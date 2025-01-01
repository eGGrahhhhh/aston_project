import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void driverSetUp() {
        driver.get("https://www.mts.by/");
        if (driver.findElement(By.cssSelector(".cookie__wrapper")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
    }

    @AfterEach
    public void driverTearDown() {
        driver.quit();
    }


    @Test
    @Order(1)
    public void getBlockNameTest() {
        String blockName = driver.findElement(By.cssSelector(".pay__wrapper h2")).getText();
        assertEquals("Онлайн пополнение\n" + "без комиссии", blockName);
    }

    @Order(2)
    @ValueSource(strings = {"[alt=\"Visa\"]", "[alt=\"Verified By Visa\"]", "[alt=\"MasterCard\"]",
            "[alt=\"MasterCard Secure Code\"]", "[alt=\"Белкарт\"]"})
    @ParameterizedTest
    public void paymentLogoExistTest(String value) {
        assertTrue(driver.findElement(By.cssSelector(value)).isDisplayed());
    }

    @Test
    @Order(3)
    public void buttonMoreAboutServiceWorksTest() {
        driver.findElement(By.cssSelector(".pay__wrapper a")).click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    @Order(4)
    public void replenishmentTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (!driver.findElement(By.className("select__now")).getText().equals("Услуги связи")) {
            WebElement typeReplenishment = driver.findElement(By.className("select__list"));
            Select select = new Select(typeReplenishment);
            select.selectByValue("Услуги связи");
        }

        driver.findElement(By.id("connection-phone")).sendKeys("(29)777-77-77");
        driver.findElement(By.cssSelector("#pay-connection .total_rub")).sendKeys("1");
        driver.findElement(By.cssSelector("#pay-connection .email")).sendKeys("test@mail.ru");
        driver.findElement(By.cssSelector("#pay-connection .button")).click();
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe.bepaid-iframe"))).isDisplayed());
    }
}
