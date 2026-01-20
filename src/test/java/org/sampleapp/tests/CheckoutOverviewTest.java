package org.sampleapp.tests;

import org.sampleapp.pages.CheckoutPage;
import org.sampleapp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends TestBase {

    @Test
    public void testCheckoutOrderDetails() {
        CheckoutPage checkoutPage = new LoginPage(driver)
                .loginAsStandardUser()
                .selectFirstProduct()
                .clickCartButton()
                .clickCheckoutButton()
                .enterFirstName("Jan")
                .enterLastName("Kowalski")
                .enterZipCode("00-001")
                .clickContinue();

        // Assertions: Ensure the Checkout screen displays the correct order details
        Assert.assertTrue(checkoutPage.isOverviewPageDisplayed(), "Overview header should be displayed!");
        Assert.assertTrue(checkoutPage.isProductTitleDisplayed(), "Product title should be displayed!");
        Assert.assertTrue(checkoutPage.isPaymentInfoDisplayed(), "Payment information should be displayed!");
        Assert.assertTrue(checkoutPage.isShippingInfoDisplayed(), "Shipping information should be displayed!");
        Assert.assertTrue(checkoutPage.isTotalPriceDisplayed(), "Total price should be displayed!");
        Assert.assertTrue(checkoutPage.isFinishButtonDisplayed(), "Finish button should be displayed!");
    }
}
