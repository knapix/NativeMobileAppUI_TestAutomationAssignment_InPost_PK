package org.sampleapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private WebElement checkoutButton;

    @AndroidFindBy(accessibility = "test-Item")
    private List<WebElement> cartItems;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title'] | //android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView")
    private List<WebElement> cartProductTitles;

    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    public CheckoutPage clickCheckoutButton() {
        logger.info("Clicking CHECKOUT button");
        scrollToElement("test-CHECKOUT");
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

    public boolean isProductNameDisplayed() {
        return !cartItems.isEmpty();
    }

    public List<String> getCartProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement title : cartProductTitles) {
            String text = title.getText();
            if (text != null && !text.isEmpty()) {
                names.add(text);
            }
        }
        return names;
    }
}
