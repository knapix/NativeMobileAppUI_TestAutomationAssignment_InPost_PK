package org.sampleapp.tests;

import org.sampleapp.pages.CartPage;
import org.sampleapp.pages.HomePage;
import org.sampleapp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddToCartTest extends TestBase {

    @Test
    public void testAddProductToCart() {
        HomePage homePage = new LoginPage(driver)
                .loginAsStandardUser();

        String expectedProductName = homePage.getFirstProductName();
        logger.info("Product name from addFirstItemToCart: " + expectedProductName);

        homePage.addFirstItemToCart();

        // Verify that 'REMOVE' button is displayed after adding to cart
        Assert.assertTrue(homePage.isRemoveButtonDisplayed(), "Remove button should be displayed after adding product to cart!");

        CartPage cartPage = homePage.clickCartButton();

        // Ensure product is displayed in the cart before proceeding
        Assert.assertTrue(cartPage.isProductNameDisplayed(), "Product should be displayed in the cart!");

        List<String> actualProductNames = cartPage.getCartProductNames();
        logger.info("Product names in the cart: " + actualProductNames);

        boolean isPresent = actualProductNames.contains(expectedProductName);
        logger.info("Comparison (expected in actual): " + isPresent);

        // Verify that added product name is visible in the cart
        Assert.assertTrue(isPresent, "Product name '" + expectedProductName + "' should be visible in the cart, but found: " + actualProductNames);
    }
}
