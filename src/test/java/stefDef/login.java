package stefDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver; //set driver for test using webdriver from selenium
    String baseUrl = "https://www.saucedemo.com/";


    @Given("user is on SauceDemo homepage")
    public void user_is_on_sauce_demo_homepage() {
        driver = new ChromeDriver(); //apply firefox driver setup
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize(); //maximize windows


        //Assertion homepage
        String productPage = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(productPage,"Swag Labs");
    }

    @When("user input valid username")
    public void user_input_valid_username() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input valid password")
    public void user_input_valid_password() {

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click Login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User is on Product Page")
    public void user_is_on_product_page() {
        driver.findElement(By.xpath("//span[@class='title']"));
        String productPage = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(productPage,"Products");
        driver.close();
    }

    @When("user input invalid username")
    public void user_input_invalid_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user1");
    }

    @Then("user get error message")
    public void user_get_error_message() {
        String errorLogin = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
