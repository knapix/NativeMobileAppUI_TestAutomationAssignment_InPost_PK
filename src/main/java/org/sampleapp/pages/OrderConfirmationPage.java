package org.sampleapp.pages;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage extends BasePage {

    @AndroidFindBy(accessibility = "test-BACK HOME")
    private WebElement backHomeButton;

    @AndroidFindBy(accessibility = "test-CHECKOUT: COMPLETE!")
    private WebElement checkoutComplete;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]")
    private WebElement thankYouMessage;

    public OrderConfirmationPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isBackHomeButtonDisplayed() {
        return isDisplayed(backHomeButton);
    }

    public boolean isCheckoutCompleteDisplayed() {
        return isDisplayed(checkoutComplete);
    }

    public boolean isThankYouMessageDisplayed() {
        return isDisplayed(thankYouMessage);
    }
}
