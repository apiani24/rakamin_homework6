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

public class logout {
    WebDriver driver; //set driver for test using webdriver from selenium
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user is already login")
    public void user_is_already_login() {
        driver = new ChromeDriver(); //apply firefox driver setup
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize(); //maximize windows


        //Assertion homepage
        String homepage = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(homepage,"Swag Labs");
        //Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click Login Button
        driver.findElement(By.id("login-button")).click();
        //Success access product page
        driver.findElement(By.xpath("//span[@class='title']"));
        String productlistPage = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(productlistPage,"Products");
    }

    @When("user click on hamburger button")
    public void user_click_on_hamburger_button() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("user click on logout")
    public void user_click_on_logout() {
        driver.findElement(By.id("menu_button_container")).isDisplayed();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User successfully logout")
    public void user_successfully_logout() {
        String sauceDemo = driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
        Assert.assertEquals(sauceDemo,"Accepted usernames are:");
        driver.close();
    }
}
