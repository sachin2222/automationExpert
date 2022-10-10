package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class Path2Usa extends Base {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://www.path2usa.com/travel-companion");
        driver.findElement(By.name("form_fields[travel_from]")).sendKeys("USA");
        driver.findElement(By.name("form_fields[travel_to]")).sendKeys("India");

       driver.findElement(By.xpath("//label[@for='form-field-travel_comp_date']")).click();

        //driver.findElement(By.cssSelector(".flatpickr-next-month")).click();

    }
}
