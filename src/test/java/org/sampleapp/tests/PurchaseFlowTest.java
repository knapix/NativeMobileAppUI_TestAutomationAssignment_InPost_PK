package org.sampleapp.tests;

import org.sampleapp.base.TestBase;
import org.sampleapp.pages.CartPage;
import org.sampleapp.pages.CheckoutPage;
import org.sampleapp.pages.HomePage;
import org.sampleapp.pages.OrderConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseFlowTest extends TestBase {

    @Test
    public void testPurchaseFlow() {

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        // 1️⃣ Dodaj produkt do koszyka
        homePage.selectFirstProduct();

        // 2️⃣ Otwórz koszyk
        homePage.clickCartButton();
        cartPage.clickCheckoutButton();

        // 3️⃣ Wypełnij dane
        checkoutPage.enterName("Jan Kowalski");
        checkoutPage.enterAddress("ul. Przykładowa 1, 00-001 Warszawa");
        checkoutPage.clickPlaceOrder();

        // 4️⃣ Sprawdź potwierdzenie
        String confirmationText = orderConfirmationPage.getConfirmationMessage().getText();
        Assert.assertTrue(confirmationText.contains("Thank you"), "Potwierdzenie zamówienia nie zawiera expected text!");
    }
}
