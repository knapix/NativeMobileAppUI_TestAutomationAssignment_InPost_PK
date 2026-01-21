package org.sampleapp.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private WebElement checkoutButton;

    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    public CheckoutPage clickCheckoutButton() {
        scrollToElement("test-CHECKOUT");
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

    public boolean isProductNameDisplayed() {
        try {
            return !driver.findElements(AppiumBy.accessibilityId("test-Item")).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> getCartProductNames() {
        List<String> names = new ArrayList<>();
        // Combined XPath to find titles by accessibility ID OR by being inside test-Description
        String combinedXPath = "//android.widget.TextView[@content-desc='test-Item title'] | " +
                               "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView";
        List<WebElement> titles = driver.findElements(AppiumBy.xpath(combinedXPath));
        for (WebElement title : titles) {
            String text = title.getText();
            if (text != null && !text.isEmpty()) {
                names.add(text);
            }
        }
        return names;
    }
}
