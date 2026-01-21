package org.sampleapp.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {
    protected AppiumDriver driver;
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void scrollToElement(String accessibilityId) {
        if (driver instanceof AndroidDriver) {
            logger.info("Scrolling to element with accessibilityId: {}", accessibilityId);
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                            + "new UiSelector().description(\"" + accessibilityId + "\"));"));
        }
    }

    public void scrollToText(String text) {
        if (driver instanceof AndroidDriver) {
            logger.info("Scrolling to text: {}", text);
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                            + "new UiSelector().text(\"" + text + "\"));"));
        }
    }

    public void scrollToTextContains(String text) {
        if (driver instanceof AndroidDriver) {
            logger.info("Scrolling to text containing: {}", text);
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                            + "new UiSelector().textContains(\"" + text + "\"));"));
        }
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isDisplayed(WebElement element, String scrollToAccessibilityId) {
        try {
            if (scrollToAccessibilityId != null) {
                scrollToElement(scrollToAccessibilityId);
            }
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isDisplayedByText(WebElement element, String text) {
        try {
            if (text != null) {
                scrollToText(text);
            }
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isDisplayedByTextContains(WebElement element, String text) {
        try {
            if (text != null) {
                scrollToTextContains(text);
            }
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
