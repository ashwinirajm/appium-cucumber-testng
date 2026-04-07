# appium-cucumber-testng

This framework showcases how two devices (Device A and Device B) execute login and logout flows using a BDD approach, ensuring consistent behavior across Android and iOS.

**Scenario:**
- Device A logs in with one account
- Device B logs in with another account
- Both sessions are validated
- Both devices log out sequentially
- Final state is verified on both devices

## Tech Stack
- Java
- Appium
- Cucumber (BDD)
- TestNG
- Maven

## Project Structure
```
appium-cucumber-testng
│
├── src/test/java
│   ├── driver/
│   │     └── DriverFactory.java   
│   │
│   ├── pages/
│   │     ├── GoogleLoginPage.java
│   │     └── SettingsPage.java
│   │
│   ├── steps/
│   │     ├── LoginSteps.java
│   │     └── Hooks.java
│   │
│   ├── utils/
│   │     ├── WaitUtils.java
│   │     ├── ScreenshotUtils.java
│   │     └── MobileUtils.java
│   │
│   └── runner/
│         └── TestRunner.java
│
├── src/test/resources
│   ├── features/
│   │     └── login_logout.feature
│   │
│   └── config/
│         └── config.properties
│
├── testng.xml
├── pom.xml
├── README.md   
└── screenshots/

```

## Features
- Multi-Device Execution (Android + iOS)
- ThreadLocal Driver Management for parallel-safe execution
- BDD with Cucumber for readable test scenarios
- Alternate Device Action Handling (Device A / Device B control)
- Page Object Model (POM) for maintainable code
- Reusable Utilities (waits, gestures, screenshots)
- Failure Screenshot Capture

## Run
mvn clean test

