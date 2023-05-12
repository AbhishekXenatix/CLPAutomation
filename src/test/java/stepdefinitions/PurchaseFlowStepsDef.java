package stepdefinitions;

import common.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WebUI;

import java.util.List;

public class PurchaseFlowStepsDef extends BaseSteps{
    TestContext testContext;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public PurchaseFlowStepsDef(TestContext context){
        super(context);
        testContext=context;
    }
    @Given("User on the home page")
    public void userOnTheHomePage() {
        driver.get("https://www.clpdomeo.com/en/");
        WebUI.sleep(2);
    }

    @And("User login as valid credential")
    public void userLoginAsValidCredential() {
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@data-validate='{required:true, email: true}']")).sendKeys("abhishektesting183@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass_non-clp']")).sendKeys("Master@07");

        driver.findElement(By.xpath("//form[@id='login-form_clp']//button[@id='send2']")).click();
    }

    @When("User want to buy {string}")
    public void userWantToBuy(String SamsungTV) {
        WebUI.sleep(3);
      WebElement searchbox =  driver.findElement(By.id("search"));
      searchbox.click();
        searchbox.sendKeys("QA55QN700BJXZK");
        searchbox.sendKeys(Keys.ENTER);
       // driver.findElement(By.linkText("55\" QN700B Neo QLED 8K Smart TV (2022) QA55QN700BJXZK(Promotion)")).click();
        js.executeScript("window.scrollBy(0,100)");
        WebUI.sleep(2);
        driver.findElement(By.xpath("//label[@for='options_24123_2']//span[@class='price-value'][normalize-space()='HK$19,980.00']")).click();
        js.executeScript("window.scrollBy(0,100)");
        js.executeScript("window.scrollBy(0,100)");


    }

    @And("User add to shopping cart")
    public void userAddToShoppingCart() {
        driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
        WebUI.sleep(3);
    }

    @Then("User should be able to buy the TV")
    public void userShouldBeAbleToBuyTheTV() {
        //driver.findElement(By.xpath("//button[@onclick='ClosePopup()']")).click();

        driver.findElement(By.linkText("View and Edit Cart")).click();
        WebUI.sleep(5);
        js.executeScript("window.scrollBy(0,600)");
        driver.findElement(By.xpath("//span[normalize-space()='Proceed to Checkout']")).click();
        WebUI.sleep(2);
        js.executeScript("window.scrollBy(0,200)");

        WebElement selectRegion = driver.findElement(By.xpath("//select[@name='region_id']"));
        Select selectFromDropDown = new Select(selectRegion);

        List<WebElement> allOptions = selectFromDropDown.getOptions();
        for (WebElement getAllOption : allOptions)
            System.out.println(getAllOption.getText());
        selectFromDropDown.selectByVisibleText("Hong Kong Island");
        WebUI.sleep(3);

        WebElement selectDistrict  =driver.findElement(By.xpath("//select[@name='custom_attributes[city_id]']"));
        Select selectFromDistrict = new Select(selectDistrict);

        List<WebElement> allOptionsDistrict = selectFromDistrict.getOptions();
        for (WebElement getAllOptionDistrict : allOptionsDistrict)
            System.out.println(getAllOptionDistrict.getText());

        selectFromDistrict.selectByVisibleText("Aberdeen");
    }

    @And("Total cost should be {string}")
    public void totalCostShouldBe(String arg0) {
    }
}
