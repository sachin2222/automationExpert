package SwagLabs.Steps;

import SwagLabs.PageObjects.LoginPageObjects;
import Utllities.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;


public class SwagLabsSteps extends Base {

    public WebDriver driver;
    LoginPageObjects loginpage;


    @Before("@Login")
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://www.saucedemo.com/");

        loginpage = new LoginPageObjects(driver);

    }


    @Given("user is on swagLabs Login Web Page")
    public void user_is_on_swag_labs_login_web_page() {
        String curerentURL = driver.getCurrentUrl();
        Assert.assertEquals(curerentURL, "https://www.saucedemo.com/");

    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginpage.setUsername(username);
        loginpage.setPassword(password);


    }

    @Then("user clicks on Login Button")
    public void user_clicks_on_login_button() {
        loginpage.clickLogin_button();

    }

    @Then("user is navigated to Home page of swagLabs Application")
    public void user_is_navigated_to_home_page_of_swag_labs_application() {

        String homePageURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(homePageURL, driver.getCurrentUrl());

    }


}
