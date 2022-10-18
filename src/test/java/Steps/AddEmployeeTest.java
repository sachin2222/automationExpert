package Steps;

import Utllities.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeeTest extends Base {
    public WebDriver driver;

    @Given("user is on home page of application")
    public void user_is_on_home_page_of_application() {
        driver = getDriver();
        boolean b = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
        Assert.assertTrue(b);
    }

    @When("user clicks on add button")
    public void user_clicks_on_add_button() {
        driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/button")).click();

    }

    @Then("user can fill {string},{string} and {string}")
    public void user_can_fill_and(String firstname, String middlename, String lastname) {
        driver.findElement(By.name("firstName")).sendKeys(firstname);
        driver.findElement(By.name("middleName")).sendKeys(middlename);
        driver.findElement(By.name("lastName")).sendKeys(lastname);

    }

    @Then("user can enter {string}")
    public void user_can_enter(String employee_ID) {
        driver.findElement(By.xpath("//div[@class='orangehrm-employee-form']/div/div[2]/div/div/div[2]/input")).sendKeys(employee_ID);
    }

    @Then("user click on Save Button")
    public void user_click_on_save_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

}
