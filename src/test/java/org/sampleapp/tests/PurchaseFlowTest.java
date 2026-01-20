package org.sampleapp.tests;

import org.sampleapp.pages.LoginPage;
import org.sampleapp.pages.OrderConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseFlowTest extends TestBase {

    @Test
    public void testPurchaseFlow() {
        OrderConfirmationPage orderConfirmationPage = new LoginPage(driver)
                .loginAsStandardUser()
                .selectFirstProduct()
                .clickCartButton()
                .clickCheckoutButton()
                .enterFirstName("Jan")
                .enterLastName("Kowalski")
                .enterZipCode("00-001")
                .clickContinue()
                .clickFinish();

        // Verify the order confirmation by Back Home button
        Assert.assertTrue(orderConfirmationPage.isOrderConfirmed(), "Order confirmation message should be displayed!");
        Assert.assertTrue(orderConfirmationPage.isBackHomeButtonDisplayed(), "Back Home button should be displayed!");
    }
}
