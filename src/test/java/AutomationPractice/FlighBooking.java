package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlighBooking extends Base {
    public WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        List<WebElement> from_cities = driver.findElements(By.cssSelector(".dropdownDiv li"));
        System.out.println(from_cities.size());
        for (int i = 0; i < from_cities.size(); i++) {
            if (from_cities.get(i).getText().contains("Goa")) {
                from_cities.get(i).click();
                break;
            }
        }

        Thread.sleep(1000);
        List<WebElement> to_cities = driver.findElements(By.cssSelector(".dropdownDiv li"));
        System.out.println(to_cities.size());
        for (int i = 0; i < to_cities.size(); i++) {
            if (to_cities.get(i).getText().contains("Patna")) {
                to_cities.get(i).click();
                break;
            }
        }

        //Select Departure Date
        Thread.sleep(1000);
        List<WebElement> dates = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
        System.out.println(dates.size() + "Dates are");
        for (int i = 0; i < dates.size(); i++) {
            if (dates.get(i).getAttribute("data-month").equals("9") && dates.get(i).getAttribute("data-year").equals("2022") && dates.get(i).getText().equals("15")) {
                dates.get(i).click();
                break;
            }

        }
        //Select Return Date

        driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).click();
        Thread.sleep(1500);
        List<WebElement> return_dates = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
        System.out.println(return_dates.size() + " return_dates are");


        for (int i = 0; i < return_dates.size(); i++) {
            if (return_dates.get(i).getAttribute("data-month").equals("9") && dates.get(i).getAttribute("data-year").equals("2022") && dates.get(i).getText().equals("31")) {
                return_dates.get(i).click();
                break;
            }

        }

        //Select Passsangers
        driver.findElement(By.cssSelector("#divpaxinfo")).click();
    }

}
