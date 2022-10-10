package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import java.util.List;

public class SpiceJet extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver=initialiseDriver("chrome");
        driver.get("https://www.spicejet.com/");
        //driver.findElement(By.cssSelector("svg[data-testid='svg-img'] g circle:nth-child(2)")).click();
        driver.findElement(By.cssSelector("input[autocapitalize='sentences']")).click();

        List<WebElement> from_cities=driver.findElements(By.cssSelector(".css-76zvg2.r-cqee49.r-ubezar.r-1kfrs79"));
        System.out.println("No of from cities are "+from_cities.size());
        for(int i=0;i<from_cities.size();i++){
            String countryname=from_cities.get(i).getText();
            if(countryname.equals("Jodhpur")){
                from_cities.get(i).click();
                break;
            }

        }

        List<WebElement> to_cities=driver.findElements(By.cssSelector(".css-76zvg2.r-cqee49.r-ubezar.r-1kfrs79"));
        System.out.println("No of to cities are "+to_cities.size());
        for(int i=0;i<to_cities.size();i++){
            String countryname=to_cities.get(i).getText();
            if(countryname.equals("Ahmedabad")){
                to_cities.get(i).click();
                break;
            }

        }

        List<WebElement> elements=driver.findElements(By.cssSelector(".css-76zvg2.r-homxoj.r-adyw6z.r-1kfrs79"));
        System.out.println("No of months are: "+ elements.size());

        for(int i=0;i<elements.size();i++){
            System.out.println(elements.get(i).getText());
            if(elements.get(i).getText().equals("October 2022")){
              List<WebElement> days=  driver.findElements(By.cssSelector(".css-76zvg2.r-homxoj.r-ubezar.r-16dba41"));
                System.out.println(days.size()+" No of days are");
                if(days.get(i).getText().equals("10")){
                    days.get(i).click();
                    break;
                }

            }
        }
    }
}
