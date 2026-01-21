package org.sampleapp.tests;

import org.sampleapp.pages.CheckoutPage;
import org.sampleapp.pages.LoginPage;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends TestBase {

    @Test
    public void testCheckoutOrderDetails() {
        CheckoutPage checkoutPage = new LoginPage(driver)
                .loginAsStandardUser()
                .addFirstItemToCart()
                .clickCartButton()
                .clickCheckoutButton()
                .enterFirstName("Jan")
                .enterLastName("Kowalski")
                .enterZipCode("00-001")
                .clickContinue();

        // Assertions: Ensure the Checkout screen displays the correct order details
        assertTrue(checkoutPage.isOverviewPageDisplayed(),
                "Overview header should be displayed!");
        assertTrue(checkoutPage.isProductTitleDisplayed(),
                "Product title should be displayed!");
        assertTrue(checkoutPage.isPaymentInfoDisplayed(),
                "Payment information should be displayed!");
        assertTrue(checkoutPage.isShippingInfoDisplayed(),
                "Shipping information should be displayed!");
        assertTrue(checkoutPage.isTotalPriceDisplayed(),
                "Total price should be displayed!");
        assertTrue(checkoutPage.isFinishButtonDisplayed(),
                "Finish button should be displayed!");
    }
}
