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
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//h2[@class = 'topic-html-content-header']")
    public WebElement welcomeText;

    @FindBy(xpath = "(//a[@href='/computers'])[1]")
    public WebElement computerMenu;

    @FindBy(xpath = "(//input[@value='Add to cart'])[1]")
    public WebElement buildYourOwnCheapComputerProductLink;


    @FindBy(xpath = "(//a[@href='/desktops'])[4]")
    public WebElement desktopLink;

    @FindBy(xpath = "//input[contains(@class,'button-1 add-to-cart-button')]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='cart-label'][contains(.,'Shopping cart')]")
    public WebElement shoppingCartLink;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Checkout')]")
    public WebElement checkoutButton;

    @FindBy(id = "termsofservice")
    public WebElement tickTermsAndConditions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyWelcomeText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        welcomeText.isDisplayed();
    }

    public  void clickOnComputerMenu(){
        computerMenu.click();
    }
    public  void clickOnDesktopLink(){
        desktopLink.click();
    }

    public void clickOnBuildYourOwnCheapComputerProductLink(){
        buildYourOwnCheapComputerProductLink.click();
    }
    public  void clickOnAddToCartButton() throws InterruptedException {
        Thread.sleep(2000);
        addToCartButton.click();
    }

    public  void clickOnShoppingCartButton(){
        shoppingCartLink.click();
    }

    public  void clickOnTermsAndConditions(){
        tickTermsAndConditions.click();
    }

    public  void clickOnCheckoutButton(){
        checkoutButton.click();
    }

}