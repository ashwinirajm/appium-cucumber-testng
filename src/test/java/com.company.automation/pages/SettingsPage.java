public class SettingsPage {

    AppiumDriver driver;

    // Locators
    By accountsOption = By.xpath("//*[contains(@text,'Accounts')]");
    By googleOption = By.xpath("//*[contains(@text,'Google')]");
    By removeAccountBtn = By.xpath("//*[contains(@text,'Remove account')]");
    By confirmRemoveBtn = By.id("android:id/button1"); // alert confirm
    By addAccount = By.xpath("//*[contains(@text,'Add account')]");

    public SettingsPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Remove Account
    public void removeAccount() {

        try {
            MobileUtils.openSettings(driver);

            WaitUtils.waitForClickable(driver, accountsOption).click();
            WaitUtils.waitForClickable(driver, googleOption).click();
            WaitUtils.waitForClickable(driver, removeAccountBtn).click();
            WaitUtils.waitForClickable(driver, confirmRemoveBtn).click();

        } catch (Exception e) {
            ScreenshotUtils.capture(driver, "logout_error");
            throw new RuntimeException("Logout failed");
        }
    }

    // Validate Logout
    public boolean isLoggedOut() {

        try {
            return WaitUtils.waitForVisibility(driver, addAccount).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
