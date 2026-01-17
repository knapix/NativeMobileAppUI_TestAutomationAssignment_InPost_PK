package org.sampleapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private WebElement checkoutButton;

    public CartPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
