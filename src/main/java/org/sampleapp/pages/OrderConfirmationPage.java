package org.sampleapp.pages;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

    private AndroidDriver driver;

    @AndroidFindBy(accessibility = "test-CHECKOUT: COMPLETE!")
    private WebElement confirmationContainer;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'THANK YOU FOR YOU ORDER') or contains(@text, 'Thank you')]")
    private WebElement confirmationMessage;

    public OrderConfirmationPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement getConfirmationMessage() {
        return confirmationMessage;
    }
}
