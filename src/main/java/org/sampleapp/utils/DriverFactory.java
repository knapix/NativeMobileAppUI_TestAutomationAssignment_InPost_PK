package org.sampleapp.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.MalformedURLException;

public class DriverFactory {

    private static String getAppPath() {
        String appPath = ConfigLoader.getProperty("app.path");
        if (appPath == null || appPath.startsWith("http")) {
            return appPath;
        }

        if (appPath.startsWith("/") || appPath.contains(":")) {
            java.io.File file = new java.io.File(appPath);
            if (file.exists()) {
                return appPath;
            }
        }
        
        // Assume relative to project root
        return System.getProperty("user.dir") + (appPath.startsWith("/") ? "" : "/") + appPath;
    }

    public static AppiumDriver createDriver() throws MalformedURLException {
        String platform = ConfigLoader.getProperty("platform", "android").toLowerCase();
        String appiumUrl = ConfigLoader.getProperty("appium.url");
        java.net.URL url = java.net.URI.create(appiumUrl).toURL();

        if (platform.equals("android")) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(ConfigLoader.getProperty("platform.name"))
                    .setAutomationName(ConfigLoader.getProperty("automation.name"))
                    .setApp(getAppPath())
                    .setAppPackage(ConfigLoader.getProperty("app.package"))
                    .setAppActivity(ConfigLoader.getProperty("app.activity"))
                    .setFullReset(ConfigLoader.getBooleanProperty("full.reset"));

            setCommonOptions(options);
            return new AndroidDriver(url, options);
        } else if (platform.equals("ios")) {
            XCUITestOptions options = new XCUITestOptions()
                    .setPlatformName(ConfigLoader.getProperty("platform.name"))
                    .setAutomationName(ConfigLoader.getProperty("automation.name"))
                    .setApp(getAppPath())
                    .setBundleId(ConfigLoader.getProperty("bundle.id"))
                    .setFullReset(ConfigLoader.getBooleanProperty("full.reset"));

            setCommonOptions(options);
            return new IOSDriver(url, options);
        } else {
            throw new RuntimeException("Unsupported platform: " + platform);
        }
    }

    private static void setCommonOptions(BaseOptions<?> options) {
        String platformVersion = ConfigLoader.getProperty("platform.version");
        if (platformVersion != null) {
            options.setCapability("appium:platformVersion", platformVersion);
        }

        String deviceName = ConfigLoader.getProperty("device.name");
        if (deviceName != null) {
            options.setCapability("appium:deviceName", deviceName);
        }
    }
}
