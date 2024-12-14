package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.Getter;

public class ExtentReportManager {

    private static ExtentReports extent;
    @Getter
    private static ExtentTest test;

    // Initialize the ExtentReports instance if not already done
    public static ExtentReports getInstance() {
        if (extent == null) {
            initializeReport();
        }
        return extent;
    }

    // Initialize the ExtentReports with configuration
    private static void initializeReport() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("src/test/report/BankAppReports.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("BankApp Automation Report");
        htmlReporter.config().setReportName("BankApp Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", System.getProperty("user.name"));
        extent.setSystemInfo("OS",System.getProperty("os.name"));
    }

    // Create a new test in the report
    public static ExtentTest createTest(String name, String description) {
        if (extent == null) {
            getInstance(); // Ensure extent is initialized
        }
        test = extent.createTest(name, description);
        return test;
    }

    // Flush the report to write to the file
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
