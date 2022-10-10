package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionsClassPractice extends Base {
    WebDriver driver;
    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    }

    @Test(priority=1)
    public void test1(){
      WebElement mouse= driver.findElement(By.id("mousehover"));
        Actions actions=new Actions(driver);
        //actions.moveToElement(mouse).build().perform();
        //actions.moveToElement(driver.findElement(By.xpath("//div[@class='mouse-hover-content']/a[2]"))).click().build().perform();

        //actions.keyDown(Keys.SHIFT).sendKeys(driver.findElement(By.id("autocomplete")),"sachin").build().perform();
        WebElement iframe=driver.findElement(By.cssSelector("#courses-iframe"));
        driver.switchTo().frame(iframe);
        actions.click(driver.findElement(By.xpath("//a[contains(@href,'sign_up')]"))).build().perform();

    }


}
