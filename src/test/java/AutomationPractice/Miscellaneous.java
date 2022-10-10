package AutomationPractice;

import Utilities.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Miscellaneous extends Base {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        driver = initialiseDriver("chrome");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    }

    @Test
    public void takescreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "\\Screenshots\\" + "scrreenshot1.png";
        FileHandler.copy(file, new File(dest));

        WebElement ele1 = driver.findElement(By.id("alertbtn"));
        File alertButtonImage = ele1.getScreenshotAs(OutputType.FILE);
        String dest1 = System.getProperty("user.dir") + "\\Screenshots\\" + "alertbtnImage.jpeg";
        FileHandler.copy(alertButtonImage, new File(dest1));

        WebElement ele2 = driver.findElement(By.id("mousehover"));
        File MouseButtonImage = ele2.getScreenshotAs(OutputType.FILE);
        String dest2 = System.getProperty("user.dir") + "\\Screenshots\\" + "mousebtnImage.jpg";
        FileHandler.copy(MouseButtonImage, new File(dest2));

    }
}
