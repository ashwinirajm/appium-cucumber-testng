public class LoginSteps {

	GoogleLoginPage loginA, loginB;
	SettingsPage settingsA, settingsB;

	@Given("both devices are initialized")
	public void init() throws Exception {
		DriverFactory.initDriver();

		loginA = new GoogleLoginPage(DriverFactory.driverA);
		loginB = new GoogleLoginPage(DriverFactory.driverB);

		settingsA = new SettingsPage(DriverFactory.driverA);
		settingsB = new SettingsPage(DriverFactory.driverB);

	}

	@When("Device A launches Google app")
	public void LaunchA() {
		MobileUtils.openGoogleApp(DriverFactory.driverA);
	}

	@When("Device B launches Google app")
	public void LaunchB() {
		MobileUtils.openGoogleApp(DriverFactory.driverB);
	}

	@When("Device A taps add account")
	public void tapA() {
		loginA.tapAddAccount();
	}

	@When("Device B taps add account")
	public void tapB() {
		loginB.tapAddAccout();
	}

	@When("Device A enters email{string}")
	public void email(String email) {
		loginA.enterEmail(email);
	}

	@When("Device B enters email{string}")
	public void emailB(String email) {
		loginB.enterEmail(email);
	}

	@When("Device A enters password{string}")
	public void passwordA(String password) {
		loginA.enterPassword(password);
	}

	@When("Device B enters password{string")
	public void passwordB(Strng password) {
		loginB.enterPassword(password);
	}

	@Then("Both devices should be logged in")
	public void validateLogin() {
		Assert.assertTrue(loginA.isLoggedIn(), "Device A login Failed");
		Assert.assertTrue(loginB.isLoggedIn(), "Device B login Failed");
	}

	@When("Device A logs out")
	public void logoutA() {
		settingsA.removeAccount();
	}

	@When("Device B logs out")
	public void logoutB() {
		settingsB.removeAccount();
	}

	@Then("Both devices should be logged out")
	public void validateLogout() {
		Assert.assertTrue(settingsA.isLoggedOut(), "Device A logout Failed");
		Assert.assertTrue(settingsB.isLoggedOut(), "Device B logout Failed");
	}
	
}
