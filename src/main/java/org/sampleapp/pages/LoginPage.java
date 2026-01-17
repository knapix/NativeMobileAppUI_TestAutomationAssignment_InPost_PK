package org.sampleapp.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private AndroidDriver driver;

    @FindBy(id = "test-standard_user")  // accessibilityId przycisku
    private WebElement standardUserButton;

    @FindBy(id = "test-LOGIN")  // przycisk Login
    private WebElement loginButton;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAsStandardUser() {
        // Klikamy przycisk gotowego standard_user
        standardUserButton.click();

        // Następnie klikamy login
        loginButton.click();
    }
}
