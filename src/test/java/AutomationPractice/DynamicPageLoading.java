package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicPageLoading extends Base {
    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        Thread.sleep(6000);
        String text = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        System.out.println(text);
    }
}
