public class WaitUtils {

    public static WebElement waitForVisibility(AppiumDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(AppiumDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}
