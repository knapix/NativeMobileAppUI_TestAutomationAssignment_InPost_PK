package org.sampleapp.pages;

import io.appium.java_client.AppiumBy;
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

    public HomePage loginAsStandardUser() {
        if (driver.findElements(AppiumBy.accessibilityId("test-standard_user")).isEmpty()) {
            return new HomePage(driver);
        }

        // Select the standard_user profile
        standardUserButton.click();

        // Perform login
        loginButton.click();
        return new HomePage(driver);

    }
}
