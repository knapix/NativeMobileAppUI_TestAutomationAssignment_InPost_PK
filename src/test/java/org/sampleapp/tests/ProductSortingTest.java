package org.sampleapp.tests;

import com.google.common.collect.Ordering;
import org.sampleapp.helper.Product;
import org.sampleapp.pages.HomePage;
import org.sampleapp.pages.LoginPage;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import java.util.List;

public class ProductSortingTest extends TestBase {

    @Test
    public void testSortProductsByPriceAscending() {
        HomePage home = new LoginPage(driver)
                .loginAsStandardUser()
                .changeProductsView()
                .sortProductsLowToHighPrice();

        List<Product> products = home.getFullyVisibleProducts();

        logger.info("=== ORDER CHECK ===");
        for (int i = 0; i < products.size(); i++) {
            logger.info(i + ": " + products.get(i).name() + " -> " + products.get(i).price());
        }

        List<Double> prices = products.stream()
                .map(Product::price)
                .toList();

        // Print prices comparison
        logger.info("=== CHECK ORDER PRICES ===");
        for (int i = 0; i < prices.size() - 1; i++) {
            logger.info("Compare " + prices.get(i) + " <= " + prices.get(i + 1) + " ? " +
                    (prices.get(i) <= prices.get(i + 1)));
        }

        assertTrue(Ordering.natural().isOrdered(prices),
                "Products are NOT sorted in ascending order");
    }
}
