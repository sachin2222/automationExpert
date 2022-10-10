package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QAClickAutomation extends Base {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

        WebElement e = driver.findElement(By.id("gf-BIG"));
        System.out.println(e.findElements(By.tagName("a")).size());

        WebElement socialmedia = driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
        List<WebElement> accounts = socialmedia.findElements(By.tagName("a"));
        System.out.println(accounts.size());

        Actions actions = new Actions(driver);

        for (int i = 1; i < accounts.size(); i++) {
            String opennewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            accounts.get(i).sendKeys(opennewTab);
        }

        Set<String> windowsid = driver.getWindowHandles();

        Iterator<String> it = windowsid.iterator();

        while (it.hasNext()) {

            String windowid = it.next();
            driver.switchTo().window(windowid);
            String title = driver.getTitle();
            System.out.println(title);
        }


    }

    @AfterSuite
    public void exit() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
