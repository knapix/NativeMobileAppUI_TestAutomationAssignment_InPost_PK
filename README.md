# Sauce Labs Mobile App Test Automation

This project is a comprehensive test automation suite for the Sauce Labs Mobile Sample App ("Swag Labs"). It utilizes a robust Page Object Model (POM) architecture to ensure maintainability and scalability across Android and iOS platforms.

## Tech Stack

*   **Language:** Java 21
*   **Test Framework:** TestNG
*   **Mobile Automation:** Appium (Java Client 8.6.0)
*   **Build Tool:** Maven
*   **Design Pattern:** Page Object Model (POM) with Fluent Interface
*   **Logging:** Logback (SLF4J)

## Project Structure

```text
├── app/                        # Application binaries (.apk, .ipa)
├── src/
│   ├── main/
│   │   ├── java/org/sampleapp/
│   │   │   ├── helper/         # Helper classes (e.g., Product record)
│   │   │   ├── pages/          # Page Objects (LoginPage, HomePage, etc.)
│   │   │   └── utils/          # Utilities (ConfigLoader, DriverFactory)
│   │   └── resources/          # Config (android.properties, ios.properties, logback.xml)
│   └── test/
│       └── java/org/sampleapp/
│           └── tests/          # Test classes (PurchaseFlowTest, AddToCartTest, etc.)
└── pom.xml                     # Maven dependencies and build configuration
```

## Prerequisites

1.  **Java JDK 21**: Ensure you have Java 21 installed.
2.  **Maven**: Installed and configured in your PATH.
3.  **Appium Server 2.x**: Running locally (default: `http://127.0.0.1:4723`).
4.  **Android Emulator / iOS Simulator**: Set up and running.
5.  **Appium Drivers**:
    *   `uiautomator2` for Android.
    *   `xcuitest` for iOS.

## Configuration

Configuration is managed via properties files in `src/main/resources`:

*   `android.properties`: Default settings for Android execution.
*   `ios.properties`: Default settings for iOS execution.

### Key Configuration Keys:

*   `platform.name`: Android or iOS.
*   `app.path`: Path to the `.apk` or `.ipa` file.
*   `appium.url`: URL of the Appium server.
*   `implicit.wait`: Timeout for element discovery (seconds).

### Overriding Configuration:

You can override any property via the command line using System Properties:
```bash
mvn test -Dplatform=android -Dimplicit.wait=20
```

## Running Tests

### Run All Tests
By default, the project runs on Android:
```bash
mvn test
```

To run on a specific platform:
```bash
mvn test -Dplatform=android
# OR
mvn test -Dplatform=ios
```

### Run Specific Test Class
```bash
mvn test -Dtest=PurchaseFlowTest
```

## Features

*   **Fluent Interface Design**: Page Objects implement a fluent API, allowing for method chaining and creating highly readable, expressive test scripts.
*   **Automatic Scrolling**: The `BasePage` includes intelligent scrolling utilities (`scrollToElement`, `scrollToText`) that ensure elements are brought into view before interaction, handling long screens gracefully.
*   **Enhanced Logging & Traceability**: Integrated Logback provides detailed, time-stamped logs of all actions, including page transitions, element interactions, and configuration loading, greatly simplifying debugging.
*   **Dynamic Driver Factory**: The `DriverFactory` handles the instantiation of `AndroidDriver` or `IOSDriver` based on runtime configuration (system properties or property files).
*   **Robust & Optimized Locators**: Uses a strategic mix of `Accessibility IDs` for speed and `UIAutomator` selectors for reliability when dynamic content is involved.
*   **Environment Flexibility**: Supports both relative and absolute paths for the application binary, and allows easy configuration overrides via command-line arguments.
