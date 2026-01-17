package org.sampleapp.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private AndroidDriver driver;

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

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterName(String name) {
        String[] names = name.split(" ");
        firstNameField.sendKeys(names[0]);
        if (names.length > 1) {
            lastNameField.sendKeys(names[1]);
        }
    }

    public void enterAddress(String address) {
        // ZIP code is used here as a placeholder for the address info required by the app
        zipCodeField.sendKeys("00-001");
    }

    public void clickPlaceOrder() {
        continueButton.click();
        // Scroll to the FINISH button using UiScrollable to ensure it's visible before clicking
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().description(\"test-FINISH\"));"));
        finishButton.click();
    }
}
