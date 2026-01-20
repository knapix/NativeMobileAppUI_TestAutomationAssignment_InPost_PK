package org.sampleapp.tests;

import org.sampleapp.pages.CartPage;
import org.sampleapp.pages.CheckoutPage;
import org.sampleapp.pages.HomePage;
import org.sampleapp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutRequiredInformationTest extends TestBase {

    @Test
    public void testFillCheckoutInformation() {
        CheckoutPage checkoutPage = new LoginPage(driver)
                .loginAsStandardUser()
                .selectFirstProduct()
                .clickCartButton()
                .clickCheckoutButton()
                .enterFirstName("Jan")
                .enterLastName("Kowalski")
                .enterZipCode("00-001")
                .clickContinue();

        // Assertion: Verify that we moved to the next step (Checkout: Overview)
        Assert.assertTrue(checkoutPage.isOverviewPageDisplayed(), "Overview header should be displayed on Checkout Overview page!");
    }
}
