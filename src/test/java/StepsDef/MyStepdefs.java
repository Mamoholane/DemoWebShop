package StepsDef;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ExtentReportManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyStepdefs {

    LoginPage loginPage;
    HomePage homePage;
    CheckoutPage checkoutPage;
    static LocalDateTime now = LocalDateTime.now();
    // Define a custom format
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    static String formattedDate = now.format(formatter);
    public static String filePath = "src/test/Screenshots/"+"screenshot"+formattedDate+".png";
    private WebDriver driver = Hooks.driver;


    @Given("User is on login screen")
    public void userIsOnLoginScreen() {
        ExtentReportManager.getTest().log(Status.INFO, "Navigating to the application...");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
        driver.get("https://demowebshop.tricentis.com/login");
    }


    @When("User enter Email {string}")
    public void userEnterEmail(String arg0) {
       loginPage.enterEmail(arg0);
    }

    @And("User enter Password {string}")
    public void userEnterPassword(String arg0) {
        loginPage.enterPassword(arg0);
    }

    @And("User click on login button")
    public void userClickOnLoginButton() {
     loginPage.clickOnLoginButton();
    }

    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        homePage.verifyWelcomeText();
    }

    @And("User go to computers menu and select desktops")
    public void userGoToComputersMenuAndSelectDesktops() {
        homePage.clickOnComputerMenu();
        homePage.clickOnDesktopLink();
    }
    @And("User choose build your own cheap computer")
    public void userChooseBuildYourOwnCheapComputer() throws InterruptedException {

        homePage.clickOnBuildYourOwnCheapComputerProductLink();
    }


    @And("User add to cart")
    public void userAddToCart() throws InterruptedException {
        homePage.clickOnAddToCartButton();
        homePage.clickOnShoppingCartButton();
        
    }

    @And("User accept Ts & Cs then checkout")
    public void userAcceptTsCsThenCheckout() {
        homePage.clickOnTermsAndConditions();
    }


    @And("User complete billing and shipping details")
    public void userCompleteBillingAndShippingDetails() {
        homePage.clickOnCheckoutButton();
    }


    @And("User complete the payment")
    public void userCompleteThePayment() throws InterruptedException {
        checkoutPage.fillBilligAddress();

    }

    @And("user confirm order")
    public void userConfirmOrder() throws InterruptedException {
        checkoutPage.clickConfirmButton();
    }

    @Then("User capture order number")
    public void userCaptureOrderNumber() throws InterruptedException {
        String orderNumber = checkoutPage.getOrderNumber();
        System.out.println(orderNumber);
    }



}