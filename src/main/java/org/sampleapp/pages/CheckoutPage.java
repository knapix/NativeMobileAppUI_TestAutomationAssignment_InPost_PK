package org.sampleapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    @AndroidFindBy(accessibility = "test-First Name")
    private WebElement firstNameField;

    @AndroidFindBy(accessibility = "test-Last Name")
    private WebElement lastNameField;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private WebElement zipCodeField;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    private WebElement continueButton;

    @AndroidFindBy(accessibility = "test-FINISH")
    private WebElement finishButton;

    @AndroidFindBy(accessibility = "test-CHECKOUT: OVERVIEW")
    private WebElement overviewHeader;

    @AndroidFindBy(accessibility = "test-Item")
    private WebElement productTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Payment Information:\")")
    private WebElement paymentInfo;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Shipping Information:\")")
    private WebElement shippingInfo;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Total:\")")
    private WebElement totalPrice;

    public CheckoutPage(AppiumDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterZipCode(String zipCode) {
        zipCodeField.sendKeys(zipCode);
        return this;
    }

    public CheckoutPage clickContinue() {
        continueButton.click();
        return this;
    }

    public boolean isFinishButtonDisplayed() {
        try {
            scrollToElement("test-FINISH");
            return finishButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOverviewPageDisplayed() {
        return overviewHeader.isDisplayed();
    }

    public boolean isProductTitleDisplayed() {
        try {
            scrollToElement("test-Item");
            return productTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPaymentInfoDisplayed() {
        try {
            scrollToText("Payment Information:");
            return paymentInfo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isShippingInfoDisplayed() {
        try {
            scrollToText("Shipping Information:");
            return shippingInfo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTotalPriceDisplayed() {
        try {
            scrollToTextContains("Total:");
            return totalPrice.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public OrderConfirmationPage clickFinish() {
        // Scroll to the FINISH button using generic helper to ensure it's visible before clicking
        logger.info("Clicking FINISH button");
        scrollToElement("test-FINISH");
        finishButton.click();
        return new OrderConfirmationPage(driver);
    }
}
