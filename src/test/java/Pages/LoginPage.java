package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(id= "Password")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement loginButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
       new WebDriverWait(driver, Duration.ofSeconds(10))
       .until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }

    public void enterPassword(String password)  {
        passwordField.sendKeys(password);

    }

    public  void clickOnLoginButton(){
        loginButton.click();
    }

}
