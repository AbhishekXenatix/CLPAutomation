package stepdefinitions;

import common.TestContext;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.WebUI;

import java.util.List;

public class UAT01Steps extends BaseSteps{
    TestContext testContext;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Select select;

    public UAT01Steps(TestContext context){
        super(context);
        testContext=context;
    }
    @Given("user will navigate to the registration page")
    public void userWillNavigateToTheRegistrationPage() {
        driver.get("https://www.clpdomeo.com/en/");
        WebUI.sleep(2);
        driver.findElement(By.linkText("Register")).click();
    }

    @When("user will enter the personal information")
    public void userWillEnterThePersonalInformation() {

        System.out.println("Now Create a New Customer Account...");
    }

    @And("user will select the title")
    public void userWillSelectTheTitle() {

        WebElement element = driver.findElement(By.id("customer_prefix_custom"));
       // js.executeScript("arguments[0].scrollIntoView();", element);
        WebUI.sleep(3);
        select= new Select(element);
        //select= new Select(driver.findElement(By.id("customer_prefix_custom")));
        select.selectByVisibleText("Mr");
    }

    @And("user will enter the name {string} and {string}")
    public void userWillEnterTheAndName(String FirstName, String LastName) {
        driver.findElement(By.id("firstname")).sendKeys(FirstName);
        driver.findElement(By.id("lastname")).sendKeys(LastName);

    }

    @And("user will enter the {string}")
    public void userWillEnterThe(String Email) {
        driver.findElement(By.id("email_address")).sendKeys(Email);
    }

    @And("user will enter the password {string} and {string}")
    public void userWillEnterThePasswordAnd(String Password, String CPassword) {
        driver.findElement(By.id("password")).sendKeys(Password);
        driver.findElement(By.id("password-confirmation")).sendKeys(CPassword);
    }


    @And("user will click on the check box")
    public void userWillClickOnTheCheckBox() {
        WebUI.sleep(2);
        js.executeScript("window.scrollBy(0,100)");
        js.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.xpath("//label[@for='subscription_2']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'I agree with the')]")).click();
        js.executeScript("window.scrollBy(0,100)");
        WebUI.sleep(2);
        driver.findElement(By.xpath("//button[@title='Register']"));


    }

    @Then("user account created")
    public void userAccountCreated() {
        WebElement ConfirmationMessage = driver.findElement(By.xpath("//*[contains(text(),'Thank you for registering!')]"));
       String ConMessage   = ConfirmationMessage.getText();
        Assert.assertEquals(ConMessage,"Thank you for registering!");
    }


}
