package org.sampleapp.tests;

import org.sampleapp.pages.CartPage;
import org.sampleapp.pages.HomePage;
import org.sampleapp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @Test
    public void testAddProductToCart() {
        HomePage homePage = new LoginPage(driver)
                .loginAsStandardUser()
                .selectFirstProduct();
        
        // Assertion 1: Verify that 'REMOVE' button is displayed after adding to cart
        Assert.assertTrue(homePage.isRemoveButtonDisplayed(), "Remove button should be displayed after adding product to cart!");

        CartPage cartPage = homePage.clickCartButton();
        
        // Assertion 2: Verify that we are on the cart page and checkout button is visible
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed(), "Checkout button should be displayed on Cart page!");
    }
}
