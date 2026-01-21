package org.sampleapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.sampleapp.helper.Product;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @AndroidFindBy(accessibility = "test-Cart")
    private WebElement cartButton;

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private List<WebElement> addToCartButtons;

    @AndroidFindBy(accessibility = "test-REMOVE")
    private List<WebElement> removeButtons;

    @AndroidFindBy(accessibility = "test-Toggle")
    private WebElement productViewButton;

    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    private WebElement filterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Price (low to high)']")
    private WebElement selectSortByLowToHighPriceButton;

    @AndroidFindBy(accessibility = "test-Item title")
    private List<WebElement> itemTitles;

    @AndroidFindBy(accessibility = "test-Price")
    private List<WebElement> priceContainers;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    // ====== DATA ======

    public List<Product> getFullyVisibleProducts() {
        List<Product> products = new ArrayList<>();

        int count = Math.min(itemTitles.size(), priceContainers.size());

        for (int i = 0; i < count; i++) {
            String name = itemTitles.get(i).getText();

            double price = Double.parseDouble(
                    priceContainers.get(i).getText().replace("$", "")
            );

            products.add(new Product(name, price));
        }

        return products;
    }

    public HomePage changeProductsView() {
        productViewButton.click();
        return this;
    }

    public HomePage clickFilterButton() {
        filterButton.click();
        return this;
    }

    public HomePage selectSortByLowToHighPrice() {
        selectSortByLowToHighPriceButton.click();
        return this;
    }

    public HomePage sortProductsLowToHighPrice() {
        clickFilterButton();
        selectSortByLowToHighPrice();
        return this;
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }

    public HomePage addFirstItemToCart() {
        if (!addToCartButtons.isEmpty()) {
            addToCartButtons.get(0).click();
        }
        return this;
    }

    public String getFirstProductName() {
        if (itemTitles.isEmpty()) {
            throw new IllegalStateException("No products available");
        }

        return itemTitles.get(0).getText();
    }

    public boolean isRemoveButtonDisplayed() {
        return !removeButtons.isEmpty() && removeButtons.get(0).isDisplayed();
    }
}