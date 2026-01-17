package org.sampleapp.tests;

import org.sampleapp.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTest extends org.sampleapp.tests.TestBase {

    @Test
    public void completePurchaseFlow() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        OrderConfirmationPage orderPage = new OrderConfirmationPage(driver);

        // Login
        loginPage.loginAsStandardUser();

        // Dodaj produkt do koszyka
        homePage.selectFirstProduct();
        homePage.clickCartButton();

        // Przejdź do koszyka
        cartPage.clickCheckoutButton();

        // Wypełnij formularz checkout
        checkoutPage.enterName("Jan Kowalski");
        checkoutPage.enterAddress("ul. Przykładowa 12, 00-001 Warszawa");
        checkoutPage.clickPlaceOrder();

        // Sprawdź ekran potwierdzenia
        String confirmation = orderPage.getConfirmationMessage().getText();
        Assert.assertTrue(confirmation.toLowerCase().contains("thank you"));
    }
}
