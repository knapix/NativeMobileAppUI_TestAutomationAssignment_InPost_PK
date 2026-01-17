package org.sampleapp.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private AndroidDriver driver;

    @FindBy(id = "com.sampleapp:id/name_field")
    private WebElement nameField;

    @FindBy(id = "com.sampleapp:id/address_field")
    private WebElement addressField;

    @FindBy(id = "com.sampleapp:id/place_order_button")
    private WebElement placeOrderButton;

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

    public void clickPlaceOrder() {
        placeOrderButton.click();
    }
}
