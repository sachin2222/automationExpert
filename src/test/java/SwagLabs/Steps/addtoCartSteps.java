package SwagLabs.Steps;

import SwagLabs.PageObjects.AddtoCartPage;
import Utllities.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class addtoCartSteps extends Base {
    WebDriver driver;
    AddtoCartPage addtoCartPage;

    @Before("@Cart")
    public void localDriver() {
        driver = getDriver();
        addtoCartPage = new AddtoCartPage(driver);
    }

    @After("@Cart")
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Given("user is already on Home page of the Application")
    public void user_is_already_on_home_page_of_the_application() {
        String homePageURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(homePageURL, driver.getCurrentUrl());
    }

    @When("user clicks on the Add to Cart Button of the Required Product")
    public void user_clicks_on_the_add_to_cart_button_of_the_required_product() {
        addtoCartPage.select_Bag_pack();

    }

    @Then("User will navigate to Add to cart Option")
    public void user_will_navigate_to_add_to_cart_option(){
        addtoCartPage.ClickShopping_cart_container();

    }

    @Then("user clicks on Checkout")
    public void user_clicks_on_checkout() {
        addtoCartPage.Checkout();

    }

    @Then("user enters Firstname , Lastname and Pincode")
    public void user_enters_firstname_lastname_and_pincode(List<Map<String, String>> data) {
        for (int i = 0; i < data.size(); i++) {
            addtoCartPage.setFirst_name(data.get(i).get("firstname"));
            addtoCartPage.setLast_name(data.get(i).get("lastname"));
            addtoCartPage.setPincode(data.get(i).get("pincode"));

        }


    }

    @Then("use clicks on continue button and Finish")
    public void use_clicks_on_continue_button_and_finish() {
        addtoCartPage.Continue();
        addtoCartPage.Finish();


    }

    @Then("user will see Required message on screen")
    public void user_will_see_required_message_on_screen(List<Map<String, String>> data) {
        String text = data.get(0).get("message");
        Assert.assertEquals(text, "THANK YOU FOR YOUR ORDER");

    }
}
