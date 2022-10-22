package Steps2;

import Utllities.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class FillformSteps extends Base {

    WebDriver driver;

    @Given("user is on web page")
    public void user_is_on_web_page() {
        driver = initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/angularpractice/");


    }

    @When("title of the page is Protocommerce")
    public void title_of_the_page_is_protocommerce() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "ProtoCommerce");

    }

    @Then("user enters form data")
    public void user_enters_form_data(List<Map<String,String>> data) throws InterruptedException {
        for(int i=0;i< data.size();i++){
            driver.findElement(By.name("name")).sendKeys(data.get(i).get("name"));
            driver.findElement(By.name("email")).sendKeys(data.get(i).get("email"));
            driver.findElement(By.id("exampleInputPassword1")).sendKeys(data.get(i).get("password"));
            driver.findElement(By.id("exampleCheck1")).click();
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            Thread.sleep(2500);

            driver.navigate().refresh();
        }

    }

}
