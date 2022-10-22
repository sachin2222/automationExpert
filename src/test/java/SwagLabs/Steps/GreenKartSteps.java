package SwagLabs.Steps;

import Utllities.Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GreenKartSteps extends Base {
    WebDriver driver;

    @Before("@Search")
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @Before("@Deal")
    public void localDriver(){
        driver=getDriver();
    }

    @Given("user is on Green kart Home Page")
    public void user_is_on_green_kart_home_page() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://rahulshettyacademy.com/seleniumPractise/#/");

    }

    @Then("user enters veggie name in search field")
    public void user_enters_veggie_name_in_search_field() {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Tomato");


    }

    @Then("user clicks on search button")
    public void user_clicks_on_search_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Then("User clicks on Top Deals link.")
    public void user_clicks_on_top_deals_link() {
        driver.findElement(By.xpath("//a[@target='_blank'][2]")).click();
        int a=10/0;


    }
}