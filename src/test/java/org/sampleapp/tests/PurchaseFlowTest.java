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

        //login
        loginPage.loginAsStandardUser();


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
        Assert.assertTrue(confirmationText.toLowerCase().contains("thank you"), "Potwierdzenie zamówienia nie zawiera expected text!");
    }
}
