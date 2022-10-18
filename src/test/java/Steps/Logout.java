package Steps;

import Utllities.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.backgroundservice.BackgroundService;

public class Logout extends Base {
    WebDriver driver;

    @Given("user is already on home page of application")
    public void user_is_already_on_home_page_of_application() {
        driver = getDriver();
        boolean b = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
        Assert.assertTrue(b);
    }

    @When("user navigates to his Profile Image")
    public void user_navigates_to_his_profile_image() {
        driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();

    }

    @Then("user clicks on logout buttton")
    public void user_clicks_on_logout_buttton() {
        driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();

    }

    @Then("user navigates to login Page")
    public void user_navigates_to_login_page() {
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(url, driver.getCurrentUrl());

    }


}
