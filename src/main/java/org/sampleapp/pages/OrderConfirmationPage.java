package org.sampleapp.pages;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage extends BasePage {

    @AndroidFindBy(accessibility = "test-CHECKOUT: COMPLETE!")
    private WebElement confirmationContainer;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'THANK YOU FOR YOU ORDER') or contains(@text, 'Thank you')]")
    private WebElement confirmationMessage;

    public OrderConfirmationPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getConfirmationMessage() {
        return confirmationMessage;
    }
}
