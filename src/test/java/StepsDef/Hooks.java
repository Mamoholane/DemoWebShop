package StepsDef;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExtentReportManager;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void beforeScenario(Scenario scenario) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ExtentReportManager.createTest(scenario.getName(), scenario.getId());
        ExtentReportManager.getTest().log(Status.INFO, "Testing " + scenario.getName() + " started");
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            // Check if the scenario passed
            if (!scenario.isFailed()) {
                ExtentReportManager.getTest().log(Status.PASS, scenario.getName() + " passed");
            } else {
                throw new Exception("Scenario failed"); // Force an exception to handle failure in the catch block
            }
        } catch (Exception e) {
            try {
                // Handle the failure case
                if (driver != null) {
                    // Take screenshot as Base64 for Extent Report
                    String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

                    // Attach screenshot to Extent Report
                    ExtentReportManager.getTest()
                            .log(Status.FAIL, scenario.getName() + " failed")
                            .fail("Screenshot of failure",
                                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());

                    // Attach screenshot to Cucumber report
                    byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
                    ExtentReportManager.getTest().log(Status.FAIL, "The: " + e.getMessage());
                    e.printStackTrace();
                } else {
                    ExtentReportManager.getTest().log(Status.FAIL, "Driver is null. Unable to take a screenshot.");
                }
            } catch (Exception screenshotException) {
                // Log the exception if screenshot capture fails
                ExtentReportManager.getTest()
                        .log(Status.FAIL, "Failed to capture screenshot: " + screenshotException.getMessage());
                screenshotException.printStackTrace();
            }

            // Log the root cause of failure
            ExtentReportManager.getTest().log(Status.FAIL, "Root cause of failure: " + e.getMessage());
            e.printStackTrace();
        }


        ExtentReportManager.getTest().log(Status.INFO, "Test " + scenario.getName() + " finished");
        ExtentReportManager.flush();

        // Quit WebDriver if initialized in this class
        if (driver != null) {
            driver.quit();
        }
    }
}
