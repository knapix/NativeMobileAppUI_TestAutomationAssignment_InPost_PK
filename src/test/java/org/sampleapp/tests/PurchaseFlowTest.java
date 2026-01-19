package org.sampleapp.tests;

import org.sampleapp.pages.CartPage;
import org.sampleapp.pages.CheckoutPage;
import org.sampleapp.pages.HomePage;
import org.sampleapp.pages.LoginPage;
import org.sampleapp.pages.OrderConfirmationPage;
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
        checkoutPage.enterFirstName("Jan");
        checkoutPage.enterLastName("Kowalski");
        checkoutPage.enterZipCode("00-001");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        // Step 5: Verify the order confirmation message
        String confirmationText = orderConfirmationPage.getConfirmationMessage().getText();
        Assert.assertTrue(confirmationText.toLowerCase().contains("thank you"), "Order confirmation message does not contain expected text!");
    }
}
