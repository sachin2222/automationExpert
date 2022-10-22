package Steps;

import Utllities.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class addReportSteps extends Base {

    WebDriver driver;

    @Given("user has  already on login page")
    public void user_has_already_on_login_page() {
        driver = initialiseDriver("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user entered username and password")
    public void user_entered_username_and_password(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
        driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
    }

    @Then("user clicked on login button")
    public void user_clicked_on_login_button() {

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user has navigated to home page")
    public void user_has_navigated_to_home_page() {
        boolean b = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
        Assert.assertTrue(b);

    }

    @Then("user navigated to Reports")
    public void user_navigated_to_reports() {
        driver.findElement(By.xpath("//nav[@aria-label='Topbar Menu']/ul/li[4]")).click();

    }

    @Then("user clicked on add button")
    public void user_clicked_on_add_button() {
        driver.findElement(By.cssSelector(".orangehrm-header-container button")).click();


    }

    @Then("user enters required reports Data")
    public void user_enters_required_reports_data() {
        driver.findElement(By.xpath("//input[@placeholder='Type here ...']")).sendKeys("TEST REPORT");

    }

}
