package org.sampleapp.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

    private AndroidDriver driver;

    @FindBy(id = "com.sampleapp:id/confirmation_message")
    private WebElement confirmationMessage;

    public OrderConfirmationPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getConfirmationMessage() {
        return confirmationMessage;
    }
}
