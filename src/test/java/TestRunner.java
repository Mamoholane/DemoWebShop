import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature/Tests.feature",
        glue = {"StepsDef","utils"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner {
}
