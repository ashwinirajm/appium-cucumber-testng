# appium-cucumber-testng

This repository demonstrates a minimal **BDD setup** for mobile automation using **Appium + Cucumber + TestNG**.

This framework is to showcase intentional use of BDD for **business-critical mobile flows**, without overengineering.

## 🧰 Tech Stack
- Java
- Appium
- Cucumber (BDD)
- TestNG
- Maven

## 📁 Project Structure
```
appium-cucumber-testng
├── pom.xml
├── README.md
├── src
│   └── test
│       ├── java
│       │   └── com.company.automation
│       │       ├── runners
│       │       ├── stepdefinitions
│       │       ├── pages
│       │       ├── utils
│       │       └── constants
│       └── resources
│           └── features
├── reports

```

## 🧪 BDD Approach
- **Feature files** describe behavior in business-readable language (Gherkin)
- **Step Definitions** act as glue between scenarios and automation code
- **Page Objects** encapsulate Appium interactions
- **Hooks** handle driver setup and teardown

## ▶️ How to Run Tests
- Start the Appium server
- Ensure Android emulator or device is running
- Update app details in FrameworkConstants.java
- Run:
  - TestRunner.java or
  - testng.xml













