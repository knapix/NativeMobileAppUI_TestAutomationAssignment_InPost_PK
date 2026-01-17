package org.sampleapp.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private AndroidDriver driver;

    // PageFactory @FindBy
    @FindBy(id = "com.sampleapp:id/cart_button")
    private WebElement cartButton;

    @FindBy(id = "com.sampleapp:id/product_1")
    private WebElement firstProduct;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void selectFirstProduct() {
        firstProduct.click();
    }
}
