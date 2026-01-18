package org.sampleapp.pages;

import io.appium.java_client.AppiumBy;
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

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[@text='CHECKOUT: OVERVIEW'] | //android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private WebElement overviewHeader;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView")
    private WebElement productTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Payment Information')]/following-sibling::android.widget.TextView[1] | //android.widget.TextView[contains(@text, 'PAYMENT INFORMATION')]/following-sibling::android.widget.TextView[1]")
    private WebElement paymentInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Shipping Information')]/following-sibling::android.widget.TextView[1] | //android.widget.TextView[contains(@text, 'SHIPPING INFORMATION')]/following-sibling::android.widget.TextView[1]")
    private WebElement shippingInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Total:')]")
    private WebElement totalPrice;

    public CheckoutPage(AppiumDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        // ZIP code is used here as a placeholder for the address info required by the app
        zipCodeField.sendKeys("00-001");
    }

    public void clickContinue() {
        continueButton.click();
    }

    public boolean isFinishButtonDisplayed() {
        return finishButton.isDisplayed();
    }

    public boolean isOverviewPageDisplayed() {
        return overviewHeader.isDisplayed();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getPaymentInfo() {
        return paymentInfo.getText();
    }

    public String getShippingInfo() {
        return shippingInfo.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void clickPlaceOrder() {
        clickContinue();
        // Scroll to the FINISH button using generic helper to ensure it's visible before clicking
        scrollToElement("test-FINISH");
        finishButton.click();
    }
}
