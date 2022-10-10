package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FramesPractice extends Base {

    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");

    }
    @Test
    public void test2(){

    }

    //@Test(enabled = false)
    public void test1() {
        WebElement topframe = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(topframe);
        System.out.println("******************************");
        System.out.println(driver.getPageSource());
        WebElement middleframe = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleframe);
        System.out.println("******************************");
        System.out.println(driver.getPageSource());

        driver.switchTo().parentFrame();
        System.out.println("******************************");
        System.out.println(driver.getPageSource());
        driver.switchTo().parentFrame();
        System.out.println("******************************");
        System.out.println(driver.getPageSource());

        WebElement bottom = driver.findElement(By.name("frame-bottom"));
        driver.switchTo().frame(bottom);
        System.out.println("******************************");
        System.out.println(driver.getPageSource());


    }


}
