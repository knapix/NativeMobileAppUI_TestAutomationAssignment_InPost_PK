package org.sampleapp.tests;

import org.sampleapp.pages.CartPage;
import org.sampleapp.pages.CheckoutPage;
import org.sampleapp.pages.HomePage;
import org.sampleapp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends TestBase {

    @Test
    public void testCheckoutOrderDetails() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.loginAsStandardUser();
        homePage.selectFirstProduct();
        homePage.clickCartButton();
        cartPage.clickCheckoutButton();

        checkoutPage.enterFirstName("Jan");
        checkoutPage.enterLastName("Kowalski");
        checkoutPage.enterZipCode("00-001");
        
        checkoutPage.clickContinue();
        
        // Assertions: Ensure the Checkout screen displays the correct order details
        Assert.assertTrue(checkoutPage.isOverviewPageDisplayed(), "Overview header should be displayed!");
        
        String productTitle = checkoutPage.getProductTitle();
        Assert.assertFalse(productTitle.isEmpty(), "Product title should not be empty!");
        Assert.assertTrue(productTitle.contains("Sauce Labs Backpack"), "Product title should be 'Sauce Labs Backpack'!");

        String paymentInfo = checkoutPage.getPaymentInfo();
        Assert.assertTrue(paymentInfo.contains("SauceCard"), "Payment information should contain 'SauceCard'!");

        String shippingInfo = checkoutPage.getShippingInfo();
        Assert.assertTrue(shippingInfo.contains("FREE PONY EXPRESS DELIVERY!"), "Shipping information should be 'FREE PONY EXPRESS DELIVERY!'!");

        String totalPrice = checkoutPage.getTotalPrice();
        Assert.assertTrue(totalPrice.contains("Total: $"), "Total price should be displayed and contain 'Total: $'!");
    }
}
