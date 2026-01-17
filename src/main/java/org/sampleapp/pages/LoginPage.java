package org.sampleapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @AndroidFindBy(accessibility = "test-standard_user")
    private WebElement standardUserButton;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;

    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginAsStandardUser() {
        // Select the standard_user profile
        standardUserButton.click();

        // Perform login
        loginButton.click();
    }
}
