public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on login screen")
    public void userOnLoginScreen() {
        // App launched via capabilities
    }

    @When("user logs in with valid credentials")
    public void login() {
        loginPage.login("testuser", "password123");
    }

    @Then("user should see home screen")
    public void verifyHome() {
        // simple assertion / visibility check
    }
}
