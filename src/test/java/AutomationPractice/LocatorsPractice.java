package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorsPractice extends Base {

    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    }

    @Test
    public void test1() {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[1]"));
        System.out.println(elements.size());
        int i=1;


            for (WebElement e : elements) {

                if(i<=elements.size()){
                    System.out.println("Name " + e.getText());
                    String xpath=String.format("//div[@class='tableFixHead']/table/tbody/tr[%d]/td[1]",i);
                    String actualXapth=xpath+"//following-sibling::td[3]";
                    String amount = e.findElement(By.xpath(actualXapth)).getText();
                    System.out.println("Amount " + amount);
                }
                i++;
            }

    }
}