import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Practice {


    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sachi\\IdeaProjects\\untitled1\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://salesforce.wd1.myworkdayjobs.com/External_Career_Site?d=cta-nav-sjb-1");

        List<WebElement> checkbox_list = driver.findElements(By.cssSelector(".WGNF"));
        System.out.println("SIZE: " + checkbox_list.size());
        for (WebElement e : checkbox_list) {
            String checkboxname = e.getText();
            String job_count = driver.findElement(By.xpath("//div[@title='" + checkboxname + "']/following-sibling::span")).getText();
            System.out.println(checkboxname + " " + job_count);
            e.click();

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(e)));

        }


    }
}
