package org.sampleapp.tests;

import io.appium.java_client.AppiumDriver;
import org.sampleapp.utils.ConfigLoader;
import org.sampleapp.utils.DriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.time.Duration;

public class TestBase {

    protected AppiumDriver driver;
    static final Logger logger = LoggerFactory.getLogger(TestBase.class);

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
