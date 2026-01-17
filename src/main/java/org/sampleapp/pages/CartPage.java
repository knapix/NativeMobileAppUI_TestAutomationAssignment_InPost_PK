package org.sampleapp.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private AndroidDriver driver;

    @FindBy(id = "com.sampleapp:id/checkout_button")
    private WebElement checkoutButton;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
