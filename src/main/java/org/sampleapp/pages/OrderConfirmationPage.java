package org.sampleapp.pages;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage extends BasePage {

    @AndroidFindBy(accessibility = "test-BACK HOME")
    private WebElement backHomeButton;

    public OrderConfirmationPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isBackHomeButtonDisplayed() {
        return backHomeButton.isDisplayed();
    }

    public boolean isOrderConfirmed() {
        return isBackHomeButtonDisplayed();
    }
}
