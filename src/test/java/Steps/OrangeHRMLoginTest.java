package Steps;

import Utllities.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMLoginTest extends Base {

    WebDriver driver;

    @Given("user is already on login page")
    public void user_is_already_on_login_page() {
        driver = initialiseDriver("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @When("user enter {string} and {string}")
    public void user_enter_and_(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("user clicks on login buttton")
    public void user_clicks_on_login_buttton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }


    @Then("user should login successfully if status of user is {string}")
    public void user_should_login_successfully_if_status_of_user_is(String status) {
        if (status.equals("valid")) {
            boolean b = driver.findElement(By.cssSelector(".oxd-userdropdown-name")).isDisplayed();
            Assert.assertTrue(b);
        } else if (status.equals("invalid")) {
            String text=driver.findElement(By.xpath("//div[@class='orangehrm-login-error']/div/div/p")).getText();
            Assert.assertEquals("Invalid credentials",text);
        }

    }


}
