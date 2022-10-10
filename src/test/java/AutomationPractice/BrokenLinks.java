package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks extends Base {

    @BeforeSuite
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void checkBrokenLinks() throws IOException{
        WebElement footer= driver.findElement(By.id("gf-BIG"));
        List<WebElement> links = footer.findElements(By.tagName("a"));


        for (int i = 0; i < links.size(); i++) {
            String url = links.get(i).getAttribute("href");


            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responsecode = connection.getResponseCode();

            if(responsecode>=400){
                System.out.println("Broken link " +url);
                System.out.println(responsecode);
            }
        }
    }
}
