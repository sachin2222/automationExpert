import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ResourcesTest extends Base {

    WebDriver driver;
    String parent_id;
    WebDriverWait wait;


    @BeforeSuite(alwaysRun = true)
    public void setup() {
        driver = initialiseDriver("chrome");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }


    @Test(priority = 1, groups = {"smoke"})
    public void navigateToURL() {
        driver.get("https://www.salesforce.com/company/careers/");
    }

    @Test(priority = 2)
    public void navigateToResources() {
        driver.findElement(By.xpath("//ul[@style='background-color: #ffffff;']/li[3]")).click();

    }

    //@Test(priority = 3)
    public void getALlBlogs_featured() throws InterruptedException {
        WebElement next = driver.findElement(By.cssSelector("a[aria-label='Next']"));
        String prev_url = driver.getCurrentUrl();
        String next_url = "";
        while (!prev_url.equals(next_url)) {

            List<WebElement> list = driver.findElements(By.xpath("//div[@role='list']/div/div/div/div/div[2]/div[2]/h3"));
            System.out.println(list.size());

            for (WebElement e : list) {
                System.out.println(e.getText());
            }

            wait.until(ExpectedConditions.elementToBeClickable(next));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[aria-label='Next']")));
            prev_url = driver.getCurrentUrl();
            next.click();
            Thread.sleep(3500);
            next_url = driver.getCurrentUrl();
        }


    }

    @Test(priority = 4)
    public void display_role_wise() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=heading_filter_group_title_0]")).click();
        driver.findElement(By.xpath("//a[@data-tag-id='engineering']")).click();
        Thread.sleep(3500);
        driver.findElement(By.cssSelector(".filters-clear-all.filters-clear-all-etc")).click();
    }

    @AfterTest(alwaysRun = true)
    public void exit() {
        driver.quit();
    }
}

