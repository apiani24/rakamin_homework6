package stefDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class addToCart {
    WebDriver driver; //set driver for test using webdriver from selenium
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user on Product Page")
    public void user_on_product_page() {
        driver = new ChromeDriver(); //apply firefox driver setup
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize(); //maximize windows


        //Assertion homepage
        String productPage = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(productPage,"Swag Labs");
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

    @When("user click Add to Cart button")
    public void user_click_add_to_cart_button() {
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

    }

    @Then("Add To Cart button turn into Remove button")
    public void add_to_cart_button_turn_into_remove_button() {
        String remove_button = driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).getText();
        Assert.assertEquals(remove_button,"Remove");
        driver.close();

    }
}
