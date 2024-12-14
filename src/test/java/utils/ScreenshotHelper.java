package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v127.page.model.Screenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {
    public static void takeScreenshot(WebDriver driver, String filePath) {
        // Cast driver to TakesScreenshot
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

        // Take the screenshot
        File srcFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

        // Specify destination file and copy the screenshot there
        try {
            FileHandler.copy(srcFile, new File(filePath));
            System.out.println("Screenshot saved at " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
