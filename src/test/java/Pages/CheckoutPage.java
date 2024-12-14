package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(id = "BillingNewAddress_Company")
    public WebElement companyField;
    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement countryDropList;
    @FindBy(id = "//h2[@class = 'topic-html-content-header']")
    public WebElement selectCountry;
    @FindBy(id = "BillingNewAddress_City")
    public WebElement cityField;
    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement address1Field;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement zipCodeField;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phoneNumberField;
    @FindBy(id = "BillingNewAddress_FaxNumber")
    public WebElement faxNumberField;
    @FindBy(xpath = "//input[contains(@onclick,'Billing.save()')]")
    public WebElement continueButton;
    @FindBy(xpath = "//input[contains(@class,'button-1 confirm-order-next-step-button')]")
    public WebElement confirmButton;
    @FindBy(xpath = "//li[contains(.,'Order number')]")
    public WebElement orderNumber;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void fillBilligAddress() throws InterruptedException {
        Thread.sleep(3000);
        companyField.sendKeys("Inspired Testing");
        countryDropList.click();
        Select select = new Select(countryDropList);
        select.selectByVisibleText("South Africa");
        cityField.sendKeys("Pretoria");
        address1Field.sendKeys("1253 Mokop street mindalore");
        zipCodeField.sendKeys("2025");
        phoneNumberField.sendKeys("0814587788");
        faxNumberField.sendKeys("0215874896544");
        continueButton.click();
        Thread.sleep(2000);
        continueButton.click();
        Thread.sleep(2000);
        continueButton.click();
        Thread.sleep(2000);
        continueButton.click();
        Thread.sleep(2000);
        continueButton.click();
    }

    public void clickConfirmButton() throws InterruptedException {
        Thread.sleep(2000);
        confirmButton.click();
    }

    public String getOrderNumber() throws InterruptedException {
        Thread.sleep(2000);
        return orderNumber.getText();
    }
}
