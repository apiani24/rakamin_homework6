package stefDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class productDetail {
    WebDriver driver; //set driver for test using webdriver from selenium
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user success access Product Page")
    public void user_success_access_product_page() {
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

    @When("user click on a product name")
    public void user_click_on_a_product_name() {
        driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).click();
    }

    @Then("User is on Product Detail Page")
    public void user_is_on_product_detail_page() {
        //Assert user success on product detail page
        String product_name = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(product_name, "Sauce Labs Bike Light");
        driver.close();
    }
}


