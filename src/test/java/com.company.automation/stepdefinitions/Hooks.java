public class Hooks {

    @Before
    public void setup(Scenario scenario) {

        try {
            System.out.println("Starting Scenario: " + scenario.getName());

            // Initialize driver (ThreadLocal)
            DriverFactory.initDriver();

        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed: " + e.getMessage());
        }
    }

    @After
    public void tearDown(Scenario scenario) {

        try {
            // Capture screenshot on failure
            if (scenario.isFailed()) {
                ScreenshotUtils.capture(
                        DriverFactory.getDriver(),
                        scenario.getName().replaceAll(" ", "_")
                );
            }

            // Quit driver
            DriverFactory.quitDriver();

            System.out.println("Finished Scenario: " + scenario.getName());

        } catch (Exception e) {
            System.out.println("Teardown failed: " + e.getMessage());
        }
    }
}
