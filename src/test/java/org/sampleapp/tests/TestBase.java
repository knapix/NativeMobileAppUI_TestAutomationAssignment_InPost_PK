package org.sampleapp.tests;

import io.appium.java_client.AppiumDriver;
import org.sampleapp.utils.ConfigLoader;
import org.sampleapp.utils.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.time.Duration;

public class TestBase {

    protected AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        int implicitWait = ConfigLoader.getIntProperty("implicit.wait");
        driver = DriverFactory.createDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
