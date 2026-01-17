package org.sampleapp.tests;

import org.sampleapp.pages.CartPage;
import org.sampleapp.pages.CheckoutPage;
import org.sampleapp.pages.HomePage;
import org.sampleapp.pages.OrderConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTest extends org.sampleapp.base.TestBase {

    @Test
    public void completePurchaseFlow() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        OrderConfirmationPage orderPage = new OrderConfirmationPage(driver);

        // Dodaj produkt do koszyka
        homePage.clickCartButton();

        // Przejdź do koszyka i sprawdź sumę
        cartPage.clickCheckoutButton();
        //Assert.assertTrue(cartPage.getTotalText().contains("Total"));

        // Wypełnij formularz checkout
        checkoutPage.enterName("Jan Kowalski");
        checkoutPage.enterAddress("ul. Przykładowa 12, 00-001 Warszawa");
        checkoutPage.clickPlaceOrder();

        // Sprawdź ekran potwierdzenia
//        String confirmation = orderPage.getConfirmationText();
//        Assert.assertTrue(confirmation.contains("Thank you"));
//        orderPage.goHome();
    }
}
