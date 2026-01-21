package org.sampleapp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    private static Properties properties;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        String platform = getProperty("platform", "android").toLowerCase();
        String fileName = platform + ".properties";
        logger.info("Loading configuration for platform: {} from file: {}", platform, fileName);
        properties = new Properties();
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                logger.error("Configuration file not found: {}", fileName);
                throw new RuntimeException("Sorry, unable to find " + fileName);
            }
            properties.load(input);
        } catch (IOException ex) {
            logger.error("Failed to load configuration file: {}", fileName, ex);
            throw new RuntimeException("Failed to load configuration file: " + fileName, ex);
        }
    }

    public static String getProperty(String key) {
        return getProperty(key, null);
    }

    public static String getProperty(String key, String defaultValue) {
        // 1. Try System Property
        String value = System.getProperty(key);

        // 2. Try Properties File
        if (value == null && properties != null) {
            value = properties.getProperty(key);
        }

        return value != null ? value : defaultValue;
    }

    public static int getIntProperty(String key) {
        return getIntProperty(key, 0);
    }

    public static int getIntProperty(String key, int defaultValue) {
        String value = getProperty(key);
        try {
            return value != null ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static boolean getBooleanProperty(String key) {
        return getBooleanProperty(key, false);
    }

    public static boolean getBooleanProperty(String key, boolean defaultValue) {
        String value = getProperty(key);
        return value != null ? Boolean.parseBoolean(value) : defaultValue;
    }
}
