package org.sampleapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    @AndroidFindBy(accessibility = "test-Cart")
    private WebElement cartButton;

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "test-REMOVE")
    private WebElement removeButton;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }

    public HomePage selectFirstProduct() {
        addToCartButton.click();
        return this;
    }

    public boolean isRemoveButtonDisplayed() {
        return removeButton.isDisplayed();
    }
}
