package org.example.lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By paymentAmountLocator = By.cssSelector(".payment-page__order-description .pay-description__cost");
    By paymentAmountButtonLocator = By.cssSelector("button.colored ");
    By numberInDescription = By.className("pay-description__text");
    By validityPeriodLocator = By.cssSelector(".content-container label.ng-tns-c46-4");
    By cartNumberLocator = By.cssSelector(".content-container label.ng-tns-c46-1");
    By cvcNumberLocator = By.cssSelector(".content-container label.ng-tns-c46-5");
    By nameOwnerLocator = By.cssSelector(".content-container label.ng-tns-c46-3");
    By iconPaymentLocator = By.cssSelector(".cards-brands .ng-tns-c61-0.ng-star-inserted img");
    By iframeLocator = By.cssSelector("iframe.bepaid-iframe");


    public void toFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
    }

    public String getPaymentAmountText() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(paymentAmountLocator)));
        return driver.findElement(paymentAmountLocator).getText();
    }


    public String getPaymentAmountButtonText() {
        return driver.findElement(paymentAmountButtonLocator).getText();
    }


    public String getNumberInDescriptionText() {
        return driver.findElement(numberInDescription).getText();
    }


    public String getValidityPeriodText() {
        return driver.findElement(validityPeriodLocator).getText();
    }


    public String getCartNumberText() {
        return driver.findElement(cartNumberLocator).getText();
    }


    public String getCvcNumberText() {
        return driver.findElement(cvcNumberLocator).getText();
    }


    public String getNameOwnerText() {
        return driver.findElement(nameOwnerLocator).getText();
    }

    public boolean getIconPayment() {
        List<WebElement> actuatIconsPayment = driver.findElements(iconPaymentLocator);
        List<String> expectedIconsPayment = List.of("visa", "mastercard", "belkart", "maestro", "mir");
        if (actuatIconsPayment.size() == expectedIconsPayment.size()) {
            for (String expectedIconPayment : expectedIconsPayment) {
                for (WebElement actuatIconPayment : actuatIconsPayment) {
                    if (actuatIconPayment.getAttribute("src").contains(expectedIconPayment)) {
                        actuatIconsPayment.remove(actuatIconPayment);
                        break;
                    }
                }
            }
        }
        return actuatIconsPayment.isEmpty();
    }
}