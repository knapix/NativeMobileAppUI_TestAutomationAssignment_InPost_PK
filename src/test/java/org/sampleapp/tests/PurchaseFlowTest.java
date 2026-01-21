package org.sampleapp.tests;

import org.sampleapp.pages.LoginPage;
import org.sampleapp.pages.OrderConfirmationPage;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class PurchaseFlowTest extends TestBase {

    @Test
    public void testPurchaseFlow() {
        OrderConfirmationPage orderConfirmationPage = new LoginPage(driver)
                .loginAsStandardUser()
                .addFirstItemToCart()
                .clickCartButton()
                .clickCheckoutButton()
                .enterFirstName("Jan")
                .enterLastName("Kowalski")
                .enterZipCode("00-001")
                .clickContinue()
                .clickFinish();

        assertTrue(orderConfirmationPage.isCheckoutCompleteDisplayed(),
                "Checkout Complete message should be displayed!");
        assertTrue(orderConfirmationPage.isThankYouMessageDisplayed(),
                "Thank you message should be displayed!");
        assertTrue(orderConfirmationPage.isBackHomeButtonDisplayed(),
                "Back Home button should be displayed!");
    }
}
