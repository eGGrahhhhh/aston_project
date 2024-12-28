package org.example.lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class HomePage {

    By sumLocator = By.cssSelector(".pay-form.opened .total_rub");
    By phoneNumberLocator = By.cssSelector(".pay-form.opened .phone");
    By scoreLocator = By.cssSelector(".pay-form.opened .score");
    By continueLocator = By.cssSelector("#pay-connection .button");
    By cookieLocator = By.cssSelector(".cookie__main.cookie__info");
    By cookieAcceptLocator = By.id("cookie-agree");
    By replenishmentLocator = By.className("select__header");
    By emailLocator = By.cssSelector(".pay-form.opened .email");
    String listReplenishmentLocator = "//*[@class='select__option' and text()='%s']";

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean cookieOnPage() {
        return driver.findElement(cookieLocator).isDisplayed();
    }

    public void cookieAccept() {
        driver.findElement(cookieAcceptLocator).click();
    }

    public void selectTypePaymentServices(String value) {
        driver.findElement(replenishmentLocator).click();
        driver.findElement(By.xpath(String.format(listReplenishmentLocator, value))).click();
    }

    public void enterPhoneNumber(String number) {
        driver.findElement(phoneNumberLocator).sendKeys(number);
    }

    public void enterScore(String number) {
        driver.findElement(scoreLocator).sendKeys(number);
    }

    public void enterSum(String sum) {
        driver.findElement(sumLocator).sendKeys(sum);
    }

    public void enterEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    public String getPhoneNumberText() {
        return driver.findElement(phoneNumberLocator).getAttribute("placeholder");
    }

    public String getScoreText() {
        return driver.findElement(scoreLocator).getAttribute("placeholder");
    }

    public String getSumText() {
        return driver.findElement(sumLocator).getAttribute("placeholder");
    }

    public String getEmailText() {
        return driver.findElement(emailLocator).getAttribute("placeholder");
    }

    public void clickСontinue() {
        driver.findElement(continueLocator).click();
    }

    public HomePage fillingDataPaymentServices(String value, String number, String sum, String email) {
        selectTypePaymentServices(value);

        if (driver.findElement(phoneNumberLocator).isDisplayed()) {
            enterPhoneNumber(number);
        } else {
            enterScore(number);
        }

        enterSum(sum);
        enterEmail(email);
        clickСontinue();
        return new HomePage(driver);
    }

    public boolean atPage() {
        if (Objects.equals(driver.getTitle(), "МТС – мобильный оператор в Беларуси")) {
            return true;
        } else {
            return false;
        }
    }
}
