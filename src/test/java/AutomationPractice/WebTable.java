package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;

import java.util.List;

public class WebTable extends Base {


    @BeforeSuite
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Display the amount, position and city of the input Name
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[1]"));
        List<WebElement> amounts = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[1]/following-sibling::td[3]"));

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).getText();
            String amount = amounts.get(i).getText();
            System.out.println(name + " " + amount);
        }

    }
}
