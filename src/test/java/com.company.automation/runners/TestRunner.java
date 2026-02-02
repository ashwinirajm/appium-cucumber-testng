@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.company.automation.stepdefinitions",
        plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
