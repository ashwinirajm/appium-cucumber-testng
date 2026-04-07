public class DriverFactory {

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static initDriver() throws Exception {
        String platform = System.getProperty("platform");
        String device = System.getProperty("device");
        String port = System.getProperty("port");

        DesiredCapabilities caps = new DesiredCapabilities();

        if(platform.equalIgnoreCase("Android")) {

            caps.setCapability("platformNme", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("udid", device);

            caps.setCapability("appPackage", "com.google.android.googlequicksearchbox");
            caps.setCapability("appActivity", "com.google.android.apps.gsa.searchnow.SearchNowActivity");

            AppiumDriver driverInstance = new AndroidDriver(new URL("https://localhost:" + port + "/wd/hub"), caps);

            driver.set(driverInstance);
        }

        else if(platform.equalsIgnoreCase("iOS")) {

            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("udid", device);

            caps.setCapability("bundleId", "com.apple.Preferences");

            AppiumDriver driverInstance = new IOSDriver(new URL("http://localhost:" + port + "/wd/hub"), caps);

            driver.set(driverInstance);
        }

    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}
