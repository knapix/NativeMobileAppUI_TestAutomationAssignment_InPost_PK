package org.sampleapp.tests;

import org.sampleapp.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseFlowTest extends TestBase {

    @Test
    public void testPurchaseFlow() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        // Step 1: Login to the application
        loginPage.loginAsStandardUser();

        // Step 2: Add the first product to the cart
        homePage.selectFirstProduct();

        // Step 3: Open the cart and proceed to checkout
        homePage.clickCartButton();
        cartPage.clickCheckoutButton();

        // Step 4: Fill in shipping details and place the order
        checkoutPage.enterName("Jan Kowalski");
        checkoutPage.enterAddress("ul. Przykładowa 1, 00-001 Warszawa");
        checkoutPage.clickPlaceOrder();

        // Step 5: Verify the order confirmation message
        String confirmationText = orderConfirmationPage.getConfirmationMessage().getText();
        Assert.assertTrue(confirmationText.toLowerCase().contains("thank you"), "Order confirmation message does not contain expected text!");
    }
}
