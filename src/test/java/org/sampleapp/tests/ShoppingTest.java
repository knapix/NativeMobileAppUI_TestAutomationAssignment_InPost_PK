package org.sampleapp.tests;

import org.sampleapp.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTest extends org.sampleapp.tests.TestBase {

    @Test
    public void completePurchaseFlow() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        OrderConfirmationPage orderPage = new OrderConfirmationPage(driver);

        // Step 1: Login
        loginPage.loginAsStandardUser();

        // Step 2: Add product to cart and navigate to cart
        homePage.selectFirstProduct();
        homePage.clickCartButton();

        // Step 3: Proceed to checkout
        cartPage.clickCheckoutButton();

        // Step 4: Fill in checkout details and complete the order
        checkoutPage.enterName("Jan Kowalski");
        checkoutPage.enterAddress("ul. Przykładowa 12, 00-001 Warszawa");
        checkoutPage.clickPlaceOrder();

        // Step 5: Verify the order confirmation
        String confirmation = orderPage.getConfirmationMessage().getText();
        Assert.assertTrue(confirmation.toLowerCase().contains("thank you"), "Order confirmation message missing expected text");
    }
}
