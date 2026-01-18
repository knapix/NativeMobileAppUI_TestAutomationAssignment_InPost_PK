package org.sampleapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "test-standard_user")
    private WebElement standardUserButton;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void loginAsStandardUser() {
        try {
            // Check if we are already logged in (e.g. standardUserButton is not visible)
            if (!standardUserButton.isDisplayed()) {
                return;
            }
        } catch (Exception e) {
            // If element is not found, we might already be logged in
            return;
        }

        // Select the standard_user profile
        standardUserButton.click();

        // Perform login
        loginButton.click();
    }
}
