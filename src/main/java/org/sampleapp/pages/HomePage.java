package org.sampleapp.pages;

import io.appium.java_client.AppiumBy;
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
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "test-REMOVE")
    private WebElement removeButton;

    @AndroidFindBy(accessibility = "test-Toggle")
    private WebElement productViewButton;

    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    private WebElement filterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Price (low to high)']")
    private WebElement selectSortByLowToHighPriceButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Price (high to low)']")
    private WebElement selectSortByHighToLowPriceButton;


    @AndroidFindBy(accessibility ="test-Item")
    private List<WebElement> getItemContainers;

    @AndroidFindBy(accessibility ="test-Price")
    private List<WebElement> getPriceContainers;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    // ====== DATA ======

    public List<Product> getFullyVisibleProducts() {



        List<Product> products = new ArrayList<>();

        int count = Math.min(getItemContainers.size(), getPriceContainers.size());

        for (int i = 0; i < count; i++) {

            String name = getItemContainers.get(i)
                    .findElement(AppiumBy.accessibilityId("test-Item title"))
                    .getText();

            double price = Double.parseDouble(
                    getPriceContainers.get(i).getText().replace("$", "")
            );

            products.add(new Product(name, price));
        }

        return products;
    }





//    public List<Product> getVisibleProducts() {
//        List<Product> products = new ArrayList<>();
//        List<WebElement> containers = driver.findElements(
//                AppiumBy.accessibilityId("test-Item")
//        );
//
//        System.out.println("Found containers: " + containers.size());
//
//        for (int i = 0; i < containers.size(); i++) {
//            WebElement container = containers.get(i);
//
//            String title = "NO TITLE";
//            double price = -1;
//
//            try {
//                title = container
//                        .findElement(AppiumBy.accessibilityId("test-Item title"))
//                        .getText();
//            } catch (Exception e) {
//                System.out.println("❌ No title for item " + i);
//            }
//
//            try {
//                String priceText = container
//                        .findElement(AppiumBy.accessibilityId("test-Price"))
//                        .getText();
//                price = Double.parseDouble(priceText.replace("$", ""));
//            } catch (Exception e) {
//                System.out.println("❌ No price for item " + i);
//            }
//
//            System.out.println(i + " -> " + title + " | " + price);
//            products.add(new Product(title, price));
//        }
//
//        return products;
//    }


    // ====== MODEL ======

//    public static class Product {
//        public final String name;
//        public final double price;
//
//        public Product(String name, double price) {
//            this.name = name;
//            this.price = price;
//        }
//    }


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

    public HomePage selectSortByHighToLowPrice() {
        selectSortByHighToLowPriceButton.click();
        return this;
    }

    public HomePage sortProductsLowToHighPrice() {
        clickFilterButton();
        selectSortByLowToHighPrice();
        return this;
    }

    public HomePage sortProductsHighToLowPrice() {
        clickFilterButton();
        selectSortByHighToLowPrice();
        return this;
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