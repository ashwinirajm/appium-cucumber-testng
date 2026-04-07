public class GoogleLoginPage {

    AppiumDriver driver;

    // Locators
    By addAccount = By.xpath("//*[contains(@text,'Add account')]");
    By emailField = By.id("identifierId");
    By nextBtn = By.xpath("//*[contains(@text,'Next')]");
    By passwordField = By.xpath("//input[@type='password']");
    By profileIcon = By.id("profile");

    public GoogleLoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Tap Add Account
    public void tapAddAccount() {
        safeClick(addAccount, "add_account");
    }

    // Enter Email
    public void enterEmail(String email) {

        try {
            MobileUtils.switchToWebView(driver);

            WebElement element = WaitUtils.waitForVisibility(driver, emailField);
            element.sendKeys(email);

            safeClick(nextBtn, "next_after_email");

        } catch (Exception e) {
            ScreenshotUtils.capture(driver, "email_error");
            throw new RuntimeException("Email step failed");
        }
    }

    // Enter Password
    public void enterPassword(String password) {

        try {
            WebElement element = WaitUtils.waitForVisibility(driver, passwordField);
            element.sendKeys(password);

            safeClick(nextBtn, "next_after_password");

            MobileUtils.switchToNative(driver);

        } catch (Exception e) {
            ScreenshotUtils.capture(driver, "password_error");
            throw new RuntimeException("Password step failed");
        }
    }

    // Validate Login
    public boolean isLoggedIn() {

        try {
            return WaitUtils.waitForVisibility(driver, profileIcon).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Safe Click Utility
    public void safeClick(By locator, String name) {

        int attempts = 0;

        while (attempts < 3) {
            try {
                WaitUtils.waitForClickable(driver, locator).click();
                return;

            } catch (Exception e) {
                attempts++;

                if (attempts == 3) {
                    ScreenshotUtils.capture(driver, name);
                    throw new RuntimeException("Click failed: " + locator);
                }
            }
        }
    }
}
