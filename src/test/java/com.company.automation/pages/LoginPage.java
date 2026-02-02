public class LoginPage {

    private AppiumDriver driver;

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    By username = By.id("com.example.app:id/username");
    By password = By.id("com.example.app:id/password");
    By loginBtn = By.id("com.example.app:id/login");

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
