package Hooks;

import Utllities.Base;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HooksSteps extends Base {


    @Before("@Sanity")
    public void setupsanity(){
        System.out.println("Before"+"sanity");
    }

    @After("@Sanity")
    public void teardownsanity(){
        System.out.println("After"+ "sanity");
    }


    @Before("@Smoke")
    public void setup(){
        System.out.println("Before"+"smoke");
    }

    @After("@Smoke")
    public void teardown(){
        System.out.println("After"+ "smoke");
    }


    @Given("user is on orange hrm live login page")
    public void user_is_on_orange_hrm_live_login_page() {

    }

    @When("user sees logo")
    public void user_sees_logo() {

    }

    @Then("user captures screenshot of logo")
    public void user_captures_screenshot_of_logo() {

    }

    @Then("user close all the browser windows")
    public void user_close_all_the_browser_windows() {

    }

    @Given("user has been created test")
    public void user_has_been_created_test() {

    }

    @Given("user has clicked on Logout")
    public void user_has_clicked_on_logout() {

    }

}
