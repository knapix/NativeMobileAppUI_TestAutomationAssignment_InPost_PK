package org.sampleapp.tests;

import org.sampleapp.pages.CartPage;
import org.sampleapp.pages.HomePage;
import org.sampleapp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @Test
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.loginAsStandardUser();
        
        homePage.selectFirstProduct();
        
        // Assertion 1: Verify that 'REMOVE' button is displayed after adding to cart
        Assert.assertTrue(homePage.isRemoveButtonDisplayed(), "Remove button should be displayed after adding product to cart!");

        homePage.clickCartButton();
        
        // Assertion 2: Verify that we are on the cart page and checkout button is visible
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed(), "Checkout button should be displayed on Cart page!");
    }
}
