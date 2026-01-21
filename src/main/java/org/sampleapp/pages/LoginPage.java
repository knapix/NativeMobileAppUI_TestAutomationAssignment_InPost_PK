package org.sampleapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "test-standard_user")
    private List<WebElement> standardUserButtons;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public HomePage loginAsStandardUser() {
        if (standardUserButtons.isEmpty()) {
            logger.info("Login screen elements not found, assuming already logged in.");
            return new HomePage(driver);
        }

        // Select the standard_user profile
        logger.info("Logging in as standard_user");
        standardUserButtons.get(0).click();

        // Perform login
        loginButton.click();
        return new HomePage(driver);
    }
}
