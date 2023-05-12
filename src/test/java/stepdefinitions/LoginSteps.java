package stepdefinitions;

import common.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginSteps extends BaseSteps{
    TestContext testContext;
    public LoginSteps(TestContext context){
        super(context);
        testContext = context;
    }
    @Given("user navigate to url {string}")
    public void userNavigateToUrl(String url) {
        System.out.println("Driver on Steps class: " + driver);
        driver.get(url);
    }
    @Then("user on the login page")
    public void userOnTheLoginPage() {
        driver.findElement(By.linkText("Login")).click();

    }
    @When("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        driver.findElement(By.xpath("//input[@data-validate='{required:true, email: true}']")).sendKeys("admin01");
        driver.findElement(By.xpath("//input[@id='pass_non-clp']")).sendKeys("123456");
    }
    @And("click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//form[@id='login-form_clp']//button[@id='send2']")).click();
    }
    @Then("The user redirect to Dashboard page")
    public void theUserRedirectToDashboardPage() {
       // WebUI.sleep(5);
    }
}
