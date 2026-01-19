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

        // Assertion: Verify that we moved to the next step (Checkout: Overview)
        Assert.assertTrue(checkoutPage.isOverviewPageDisplayed(), "Overview header should be displayed on Checkout Overview page!");
    }
}
